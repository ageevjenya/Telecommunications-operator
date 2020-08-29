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
public class ModemController {
    private final ModemService service;

    public ModemController(ModemService service) {
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
    public String modem(@PathVariable("id") int id, Model model) {
        model.addAttribute("modem", service.getById(id));
        return "modem";
    }
}
