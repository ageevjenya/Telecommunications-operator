package com.netcracker.app.domain.shop.controllers;

import com.netcracker.app.domain.shop.services.TechService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TechController {
    private final TechService service;

    public TechController(TechService service) {
        this.service = service;
    }

    @GetMapping("/tech")
    public String modem(Model model) {
        return "tech";
    }

}
