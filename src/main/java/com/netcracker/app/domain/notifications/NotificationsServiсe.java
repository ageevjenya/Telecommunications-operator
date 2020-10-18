package com.netcracker.app.domain.notifications;

import com.netcracker.app.domain.users.entities.User;
import com.netcracker.app.domain.users.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class NotificationsServiсe {

    @Autowired
    NotificationRepo notificationRepo;
    @Autowired
    UserRepo userRepo;

    public void AddNewNotificationInBDonDesctiption(String description){
        User user = userRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

        Notification notification = new Notification(description, user);

        notificationRepo.save(notification);
//        ScriptEngineManager manager = new ScriptEngineManager();
//        ScriptEngine engine = manager.getEngineByName("JavaScript");
//        // read script file
//        engine.eval(Files.newBufferedReader(Paths.get("../static/jsfunctions/notifications.js"), StandardCharsets.UTF_8));
//
//        Invocable inv = (Invocable) engine;
//        // call function from script file
//        inv.invokeFunction("notificationAllActive", "");
    }
}
