package com.netcracker.app.domain.shop.controllers;

import com.netcracker.app.domain.shop.repositories.ModemRepository;
import com.netcracker.app.domain.shop.services.ModemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ModemController {
    private final ModemService service;
    private final ModemRepository repository;

    public ModemController(ModemService service, ModemRepository modemRepository) {
        this.service = service;
        this.repository = modemRepository;
    }

    @GetMapping("/modem")
    public String modem(Model model) {
        return "modem";
    }
}
