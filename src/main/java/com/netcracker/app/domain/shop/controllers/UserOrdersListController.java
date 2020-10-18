package com.netcracker.app.domain.shop.controllers;

import com.netcracker.app.domain.notifications.NotificationsServiсe;
import com.netcracker.app.domain.shop.entities.UserOrder;
import com.netcracker.app.domain.shop.repositories.UserOrderRepository;
import com.netcracker.app.domain.users.entities.User;
import com.netcracker.app.domain.users.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.stream.Collectors;

@Controller
public class UserOrdersListController {
    private final UserRepo userRepo;
    private final UserOrderRepository userOrderRepository;
    @Autowired
    NotificationsServiсe notificationsServiсe;

    public UserOrdersListController(UserRepo userRepo, UserOrderRepository userOrderRepository) {
        this.userRepo = userRepo;
        this.userOrderRepository = userOrderRepository;
    }

    @GetMapping("/userOrdersList")
    public String listUserOrders(Model model) {
        User user = userRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        if (user == null || user.getRoles().stream().noneMatch(e -> e.getAuthority().equals("SUPPORT") || e.getAuthority().equals("ADMIN"))) {
            return "/";
        }

        model.addAttribute("orders", userOrderRepository.findAll().stream()
                .filter(e -> e.getStatus() == null || e.getStatus().equals("принят")).collect(Collectors.toList()));
        return "userOrdersList";
    }

    @PostMapping("/yesOrder")
    public String yesOrder(@RequestParam("orderId") long id) {
        UserOrder userOrder = userOrderRepository.getOne(id);
        userOrder.setStatus("принят");
        userOrderRepository.saveAndFlush(userOrder);
        User user = userRepo.getOne(userOrder.getUser().getId());
        String description = "Ваш заказ: " + userOrder.getId() + " - " + userOrder.getStatus();
        notificationsServiсe.AddNewNotificationInBDonDescriptionToOtherUser(description, user);
        return "redirect:/userOrdersList";
    }

    @PostMapping("/noOrder")
    public String noOrder(@RequestParam("orderId") long id) {
        UserOrder userOrder = userOrderRepository.getOne(id);
        userOrder.setStatus("отказ");
        userOrderRepository.saveAndFlush(userOrder);
        User user = userRepo.getOne(userOrder.getUser().getId());
        String description = "Ваш заказ: " + userOrder.getId() + " - " + userOrder.getStatus();
        notificationsServiсe.AddNewNotificationInBDonDescriptionToOtherUser(description, user);
        return "redirect:/userOrdersList";
    }

    @PostMapping("/dev")
    public String dev(@RequestParam("orderId") long id) {
        UserOrder userOrder = userOrderRepository.getOne(id);
        userOrder.setStatus("доставлен");
        userOrderRepository.saveAndFlush(userOrder);
        User user = userRepo.getOne(userOrder.getUser().getId());
        String description = "Ваш заказ: " + userOrder.getId() + " - " + userOrder.getStatus();
        notificationsServiсe.AddNewNotificationInBDonDescriptionToOtherUser(description, user);
        return "redirect:/userOrdersList";
    }
}
