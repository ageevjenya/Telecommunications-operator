package com.netcracker.app.domain.notifications;

import com.netcracker.app.domain.requests.Request;
import com.netcracker.app.domain.users.entities.User;
import com.netcracker.app.domain.users.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class NotificationRestController {
    @Autowired
    NotificationRepo notificationRepo;

    @Autowired
    UserRepo userRepo;

    @GetMapping(value = "/notifications/all", headers = {"Content-type=application/json"})
    public Iterable<Notification> notifications() {
        User user = userRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

        Iterable<Notification> notifications = notificationRepo.findAllActiveNotificationsNative(user);
        return notifications;
    }
    @Transactional
    @PostMapping(value = "/notifications/changeActive", headers = {"Content-type=application/json"})
    public void notificationChangeActive(@RequestBody Notification notification) {
        Notification notificationBD = notificationRepo.findById(notification.getId()).get();
        notificationBD.setActive(!notificationBD.isActive());
        notificationRepo.save(notificationBD);
    }

    @GetMapping(value = "/notifications/product", headers = {"Content-type=application/json"})
    public Notification productNotifications() {
        User user = userRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        return notificationRepo.getByProductAndActiveAndUser(user);
    }

    @GetMapping(value = "/notifications/allCount", headers = {"Content-type=application/json"})
    public Iterable<Notification> notificationsCount() {
        User user = userRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

        Iterable<Notification> notifications = notificationRepo.findAllActiveNotificationsNative(user);
        return notifications;
    }
}
