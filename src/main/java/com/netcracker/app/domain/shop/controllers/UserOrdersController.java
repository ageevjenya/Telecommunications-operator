package com.netcracker.app.domain.shop.controllers;

import com.netcracker.app.domain.shop.entities.UserOrder;
import com.netcracker.app.domain.shop.repositories.UserOrderRepository;
import com.netcracker.app.domain.users.entities.User;
import com.netcracker.app.domain.users.repositories.UserRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserOrdersController {
    private final UserRepo userRepo;
    private final UserOrderRepository userOrderRepository;

    public UserOrdersController(UserRepo userRepo, UserOrderRepository userOrderRepository) {
        this.userRepo = userRepo;
        this.userOrderRepository = userOrderRepository;
    }

    @GetMapping("/userOrders")
    public String userOrders(Model model) {
        User user = userRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

        List<UserOrder> userOrders = userOrderRepository.findAllByUserId(user.getId());

        model.addAttribute("orders", userOrders);
        return "userOrders";
    }
}
