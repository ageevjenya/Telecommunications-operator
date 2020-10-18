package com.netcracker.app.domain.users.controllers;

import com.netcracker.app.domain.messages.Message;
import com.netcracker.app.domain.requests.Request;
import com.netcracker.app.domain.users.entities.User;
import com.netcracker.app.domain.users.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {
    @Autowired
    UserRepo userRepo;

    @GetMapping(value = "/user/auth", headers = {"Content-type=application/json"})
    public User messagesOnRequest() {
        User user = userRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

        return user ;
    }
}
