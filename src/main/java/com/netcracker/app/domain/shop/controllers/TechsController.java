package com.netcracker.app.domain.shop.controllers;

import com.netcracker.app.domain.shop.services.TechService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/techs")
public class TechsController {
    private final TechService service;

    public TechsController(TechService service) {
        this.service = service;
    }

    @GetMapping
    public String techs(@RequestParam(required = false) String filter, Model model) {
        if (filter != null && !filter.isEmpty()) {
            model.addAttribute("techs", service.getAllByName(filter));
        } else {
            model.addAttribute("techs", service.getAll());
        }
        model.addAttribute("filter", filter);
        return "techs";
    }

    @GetMapping("/{id}")
    public String tech(@PathVariable("id") int id, Model model) {
        model.addAttribute("tech", service.getById(id));
        return "tech";
    }
}
