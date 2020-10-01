package com.netcracker.app.domain.shop.controllers;

import com.netcracker.app.domain.shop.services.ModemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/modems")
public class ModemsController {
    private final ModemService service;

    public ModemsController(ModemService service) {
        this.service = service;
    }

    @GetMapping
    public String modems(@RequestParam(required = false) String filter, Model model) {
        if (filter != null && !filter.isEmpty()) {
            model.addAttribute("modems", service.getAllByName(filter));
        } else {
            model.addAttribute("modems", service.getAll());
        }
        model.addAttribute("filter", filter);
        return "modems";
    }

    @GetMapping("/{id}")
    public String all(@PathVariable("id") int id, Model model) {
        model.addAttribute("modem", service.getById(id));
        return "modem";
    }

    @GetMapping("/Modem")
    public String modem(Model model) {
        model.addAttribute("modems", service.getAllByName("Modem"));
        return "modems";
    }

    @GetMapping("/Router")
    public String router(Model model) {
        model.addAttribute("modems", service.getAllByName("Router"));
        return "modems";
    }
}
