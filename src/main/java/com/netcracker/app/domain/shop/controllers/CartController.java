package com.netcracker.app.domain.shop.controllers;

import com.netcracker.app.domain.notifications.NotificationsServiсe;
import com.netcracker.app.domain.shop.entities.Cart;
import com.netcracker.app.domain.shop.entities.ProductModemInfo;
import com.netcracker.app.domain.shop.entities.ProductTechInfo;
import com.netcracker.app.domain.shop.repositories.CartRepository;
import com.netcracker.app.domain.shop.repositories.ProductModemInfoRepository;
import com.netcracker.app.domain.shop.repositories.ProductTechInfoRepository;
import com.netcracker.app.domain.shop.repositories.UserOrderRepository;
import com.netcracker.app.domain.users.entities.User;
import com.netcracker.app.domain.users.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CartController {
    private final CartRepository cartRepository;
    private final UserRepo userRepo;
    private final UserOrderRepository userOrderRepository;
    private final ProductModemInfoRepository productModemInfoRepository;
    private final ProductTechInfoRepository productTechInfoRepository;
    @Autowired
    NotificationsServiсe notificationsServiсe;

    public CartController(CartRepository cartRepository, UserRepo userRepo,
                          UserOrderRepository userOrderRepository,
                          ProductTechInfoRepository productTechInfoRepository,
                          ProductModemInfoRepository productModemInfoRepository) {
        this.cartRepository = cartRepository;
        this.userOrderRepository = userOrderRepository;
        this.userRepo = userRepo;
        this.productModemInfoRepository = productModemInfoRepository;
        this.productTechInfoRepository = productTechInfoRepository;
    }

    @GetMapping("/cart")
    public String cart(Model model) {
        User user = userRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("user", user);
        model.addAttribute("cart", cartRepository.getOne(user.getCart().getId()));
        return "cart";
    }

    @GetMapping("/deleteModem/{id}")
    public String removeModemFromCart(@PathVariable("id") ProductModemInfo productModemInfo, Model model) throws Exception {
        User user = userRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        productModemInfo.setAmount(0);
        productModemInfoRepository.saveAndFlush(productModemInfo);
        Cart cart = cartRepository.getOne(user.getCart().getId());
        cart.setCounts();
        cart.setFullPrice();
        cartRepository.saveAndFlush(cart);
        notificationsServiсe.AddNewNotificationToCart();

        model.addAttribute("user", user);
        model.addAttribute("cart", cart);
        return "cart";
    }

    @GetMapping("/deleteTech/{id}")
    public String removeTechFromCart(@PathVariable("id")ProductTechInfo productTechInfo, Model model) throws Exception {
        User user = userRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        productTechInfo.setAmount(0);
        productTechInfoRepository.saveAndFlush(productTechInfo);
        Cart cart = cartRepository.getOne(user.getCart().getId());
        cart.setCounts();
        cart.setFullPrice();
        cartRepository.saveAndFlush(cart);
        notificationsServiсe.AddNewNotificationToCart();

        model.addAttribute("user", user);
        model.addAttribute("cart", cart);
        return "cart";
    }

    @GetMapping("/plusAmountModem/{id}")
    public String plusAmountModem(@PathVariable("id") ProductModemInfo productModemInfo, Model model) throws Exception {
        User user = userRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        productModemInfo.setAmount(1);
        productModemInfoRepository.saveAndFlush(productModemInfo);
        Cart cart = cartRepository.getOne(user.getCart().getId());
        cart.setCounts();
        cart.setFullPrice();
        cartRepository.saveAndFlush(cart);

        model.addAttribute("user", user);
        model.addAttribute("cart", cart);
        return "redirect:/cart";
    }

    @GetMapping("/minusAmountModem/{id}")
    public String minusAmountModem(@PathVariable("id") ProductModemInfo productModemInfo, Model model) throws Exception {
        User user = userRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        productModemInfo.setAmount(-1);
        productModemInfoRepository.saveAndFlush(productModemInfo);
        Cart cart = cartRepository.getOne(user.getCart().getId());
        cart.setCounts();
        cart.setFullPrice();
        cartRepository.saveAndFlush(cart);

        model.addAttribute("user", user);
        model.addAttribute("cart", cart);
        return "redirect:/cart";
    }

    @GetMapping("/plusAmountTech/{id}")
    public String plusAmountTech(@PathVariable("id") ProductTechInfo productTechInfo, Model model) throws Exception {
        User user = userRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        productTechInfo.setAmount(1);
        productTechInfoRepository.saveAndFlush(productTechInfo);
        Cart cart = cartRepository.getOne(user.getCart().getId());
        cart.setCounts();
        cart.setFullPrice();
        cartRepository.saveAndFlush(cart);

        model.addAttribute("user", user);
        model.addAttribute("cart", cart);
        return "redirect:/cart";
    }

    @GetMapping("/minusAmountTech/{id}")
    public String minusAmountTech(@PathVariable("id") ProductTechInfo productTechInfo, Model model) throws Exception {
        User user = userRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        productTechInfo.setAmount(-1);
        productTechInfoRepository.saveAndFlush(productTechInfo);
        Cart cart = cartRepository.getOne(user.getCart().getId());
        cart.setCounts();
        cart.setFullPrice();
        cartRepository.saveAndFlush(cart);

        model.addAttribute("user", user);
        model.addAttribute("cart", cart);
        return "redirect:/cart";
    }
}
