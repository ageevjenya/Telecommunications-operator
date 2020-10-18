package com.netcracker.app.domain.shop.controllers;

import com.netcracker.app.domain.notifications.NotificationsServiсe;
import com.netcracker.app.domain.shop.entities.Cart;
import com.netcracker.app.domain.shop.entities.ProductTechInfo;
import com.netcracker.app.domain.shop.entities.Tech;
import com.netcracker.app.domain.shop.repositories.CartRepository;
import com.netcracker.app.domain.shop.repositories.ImgTechRepository;
import com.netcracker.app.domain.shop.repositories.ProductTechInfoRepository;
import com.netcracker.app.domain.shop.repositories.TechRepository;
import com.netcracker.app.domain.shop.services.TechService;
import com.netcracker.app.domain.users.entities.User;
import com.netcracker.app.domain.users.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class TechController {
    private final TechService service;
    private final UserRepo userRepo;
    private final CartRepository cartRepository;
    private final ProductTechInfoRepository techInfoRepository;
    private final ImgTechRepository imgTechRepository;
    private final TechRepository repository;
    @Autowired
    NotificationsServiсe notificationsServiсe;

    public TechController(TechService service, UserRepo userRepo, CartRepository cartRepository,
                          ProductTechInfoRepository techInfoRepository, ImgTechRepository imgTechRepository,
                          TechRepository repository) {
        this.service = service;
        this.userRepo = userRepo;
        this.cartRepository = cartRepository;
        this.techInfoRepository = techInfoRepository;
        this.imgTechRepository = imgTechRepository;
        this.repository = repository;
    }

    @GetMapping("/tech")
    public String tech(Model model) {
        return "tech";
    }

    @GetMapping("/tech/{id}")
    public String addToCartTech(@PathVariable("id") Tech tech, Model model) throws Exception {
        User user = userRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        if (user == null) {
            return "login";
        }
        Cart cart = cartRepository.getOne(user.getCart().getId());
        if (cart.getProductTechInfos() != null) {
            List<ProductTechInfo> techInfos = cart.getProductTechInfos().stream().filter(e -> {
                try {
                    return e.getDevice().getId().equals(tech.getId());
                } catch (Exception ex) {
                    ex.printStackTrace();
                    return false;
                }
            }).collect(Collectors.toList());
            if (techInfos.size() != 0) {
                techInfos.get(0).setAmount(1);
                techInfos.get(0).setPrice();
                techInfoRepository.saveAndFlush(techInfos.get(0));
            } else {
                ProductTechInfo productTechInfo = new ProductTechInfo(tech, 1, cart);
                techInfoRepository.save(productTechInfo);
                cart.setProductTechInfos(productTechInfo);
            }
        } else {
            ProductTechInfo productTechInfo = new ProductTechInfo(tech, 1, cart);
            techInfoRepository.save(productTechInfo);
            cart.setProductTechInfos(productTechInfo);
        }
        cart.setCounts();
        cart.setFullPrice();
        cartRepository.saveAndFlush(cart);
        notificationsServiсe.AddNewNotificationToCart();

        model.addAttribute("imgs", imgTechRepository.findAllByTechId(tech.getId()));
        model.addAttribute("tech", repository.getOne(tech.getId()));
        model.addAttribute("cart", cart);
        return "tech";
    }

}