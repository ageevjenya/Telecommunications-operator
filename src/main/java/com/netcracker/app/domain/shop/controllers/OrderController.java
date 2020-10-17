package com.netcracker.app.domain.shop.controllers;

import com.netcracker.app.domain.shop.entities.Cart;
import com.netcracker.app.domain.shop.entities.UserOrder;
import com.netcracker.app.domain.shop.repositories.CartRepository;
import com.netcracker.app.domain.shop.repositories.UserOrderRepository;
import com.netcracker.app.domain.users.entities.User;
import com.netcracker.app.domain.users.repositories.UserRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderController {
    private final UserRepo userRepo;
    private final CartRepository cartRepository;
    private final UserOrderRepository userOrderRepository;

    public OrderController(UserRepo userRepo, CartRepository cartRepository, UserOrderRepository userOrderRepository) {
        this.userRepo = userRepo;
        this.cartRepository = cartRepository;
        this.userOrderRepository = userOrderRepository;
    }

    @GetMapping("/createOrder")
    public String order(Model model) {
        User user = userRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("user", user);
        model.addAttribute("cart", cartRepository.getOne(user.getCart().getId()));
        return "createOrder";
    }

    @PostMapping("/createOrder")
    public String postOrder(@RequestParam("phone") String phone,
                            @RequestParam("stringOrder") String stringOrder,
                            @RequestParam("address") String address, Model model) throws Exception {
        User user = userRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        UserOrder order = new UserOrder(phone, address, stringOrder);
        order.setUser(user);
        userOrderRepository.save(order);
        user.setUserOrder(order);
        userRepo.saveAndFlush(user);
        Cart cart = cartRepository.getOne(user.getCart().getId());
        cart.getProductModemInfos().stream().forEach(e -> {
            try {
                e.setAmount(0);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        cart.getProductTechInfos().stream().forEach(e -> {
            try {
                e.setAmount(0);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        cart.setCounts();
        cart.setFullPrice();
        cartRepository.saveAndFlush(cart);
        model.addAttribute("order", order);
        return "newOrder";
    }
}
