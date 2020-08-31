package com.netcracker.app.domain.shop.controllers;

import com.netcracker.app.domain.shop.services.ModemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ModemController {
    private final ModemService service;

    public ModemController(ModemService service) {
        this.service = service;
    }

    @GetMapping("/modem")
    public String modem(Model model) {
        return "modem";
    }
}
