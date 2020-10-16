package com.netcracker.app.domain.requests;

import com.netcracker.app.domain.users.entities.User;
import com.netcracker.app.domain.users.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@Controller
@RequestMapping("/requests")
public class RequestsController {

    @Autowired
    private RequestRepo requestRepo;

    @Autowired
    private UserRepo userRepo;

    @GetMapping
    public String requests(Model model) {
//        model.addAttribute("requests", requestRepo.findByOrderByActiveDesc());
        return "requests";
    }

    @PostMapping
    public String requests(@RequestParam String description, Model model) {
        User user = userRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        Request request = new Request(description, LocalDateTime.now().withNano(0) ,user);
        requestRepo.save(request);
        model.addAttribute("requests", requestRepo.findByOrderByActiveDesc());
        return "requests";
    }


}
