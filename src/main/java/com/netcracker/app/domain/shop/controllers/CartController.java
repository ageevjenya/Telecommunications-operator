package com.netcracker.app.domain.shop.controllers;

import com.netcracker.app.domain.shop.entities.UserOrder;
import com.netcracker.app.domain.shop.repositories.CartRepository;
import com.netcracker.app.domain.shop.repositories.ProductModemInfoRepository;
import com.netcracker.app.domain.shop.repositories.ProductTechInfoRepository;
import com.netcracker.app.domain.shop.repositories.UserOrderRepository;
import com.netcracker.app.domain.users.entities.User;
import com.netcracker.app.domain.users.repositories.UserRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {
    private final CartRepository cartRepository;
    private final UserRepo userRepo;
    private final UserOrderRepository userOrderRepository;
    private final ProductModemInfoRepository productModemInfoRepository;
    private final ProductTechInfoRepository productTechInfoRepository;

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
}
