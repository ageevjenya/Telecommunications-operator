package com.netcracker.app.domain.shop.controllers;

import com.netcracker.app.domain.notifications.NotificationsServiсe;
import com.netcracker.app.domain.shop.entities.Cart;
import com.netcracker.app.domain.shop.entities.Modem;
import com.netcracker.app.domain.shop.entities.ProductModemInfo;
import com.netcracker.app.domain.shop.repositories.CartRepository;
import com.netcracker.app.domain.shop.repositories.ImgModemRepository;
import com.netcracker.app.domain.shop.repositories.ModemRepository;
import com.netcracker.app.domain.shop.repositories.ProductModemInfoRepository;
import com.netcracker.app.domain.shop.services.ModemService;
import com.netcracker.app.domain.users.entities.User;
import com.netcracker.app.domain.users.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ModemController {
    private final ModemService service;
    private final ModemRepository repository;
    private final UserRepo userRepo;
    private final CartRepository cartRepository;
    private final ProductModemInfoRepository productModemInfoRepository;
    private final ImgModemRepository imgModemRepository;
    @Autowired
    NotificationsServiсe notificationsServiсe;

    public ModemController(ModemService service, ModemRepository modemRepository, UserRepo userRepo,
                           CartRepository cartRepository, ProductModemInfoRepository productModemInfoRepository, ImgModemRepository imgModemRepository) {
        this.service = service;
        this.repository = modemRepository;
        this.userRepo = userRepo;
        this.cartRepository = cartRepository;
        this.productModemInfoRepository = productModemInfoRepository;
        this.imgModemRepository = imgModemRepository;
    }

    @GetMapping("/modem")
    public String modem(Model model) {
        return "modem";
    }


    @GetMapping("/modem/{id}")
    public String addToCartModem(@PathVariable("id") Modem modem, Model model) throws Exception {
        User user = userRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        if (user == null) {
            return "login";
        }
        Cart cart = cartRepository.getOne(user.getCart().getId());
        if (cart.getProductModemInfos() != null) {
            List<ProductModemInfo> modemInfoList = cart.getProductModemInfos().stream().filter(e -> {
                try {
                    return e.getDevice().getId().equals(modem.getId());
                } catch (Exception ex) {
                    ex.printStackTrace();
                    return false;
                }
            }).collect(Collectors.toList());
            if (modemInfoList.size() != 0) {
                modemInfoList.get(0).setAmount(1);
                modemInfoList.get(0).setPrice();
                productModemInfoRepository.saveAndFlush(modemInfoList.get(0));
            } else {
                ProductModemInfo productModemInfo = new ProductModemInfo(modem, 1, cart);
                productModemInfoRepository.save(productModemInfo);
                cart.setProductModemInfos(productModemInfo);
            }
        } else {
            ProductModemInfo productModemInfo = new ProductModemInfo(modem, 1, cart);
            productModemInfoRepository.save(productModemInfo);
            cart.setProductModemInfos(productModemInfo);
        }
        cart.setCounts();
        cart.setFullPrice();
        cartRepository.saveAndFlush(cart);
        notificationsServiсe.AddNewNotificationToCart();

        model.addAttribute("imgs", imgModemRepository.findAllByModemId(modem.getId()));
        model.addAttribute("modem", repository.getOne(modem.getId()));
        model.addAttribute("cart", cart);
        return "modem";
    }
}
