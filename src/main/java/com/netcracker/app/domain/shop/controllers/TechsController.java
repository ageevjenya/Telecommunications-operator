package com.netcracker.app.domain.shop.controllers;

import com.netcracker.app.domain.shop.repositories.ImgTechRepository;
import com.netcracker.app.domain.shop.repositories.TechRepository;
import com.netcracker.app.domain.shop.services.TechService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/techs")
public class TechsController {
    private final TechService service;
    private final ImgTechRepository imgTechRepository;
    private final TechRepository repository;

    public TechsController(TechService service, ImgTechRepository imgTechRepository, TechRepository repository) {
        this.service = service;
        this.imgTechRepository = imgTechRepository;
        this.repository = repository;
    }

    @GetMapping("/techs")
    public String techs(@RequestParam(required = false) String filter, Model model,
                        @PageableDefault(sort = { "id"}, direction = Sort.Direction.DESC)Pageable pageable) {
        if (filter != null && !filter.isEmpty()) {
            model.addAttribute("page", repository.getAllByName(filter, pageable));
        } else {
            model.addAttribute("page", repository.findAll(pageable));
        }
        model.addAttribute("url", "/techs");
        model.addAttribute("filter", filter);
        return "techs";
    }

    @GetMapping("/techs/{id}")
    public String tech(@PathVariable("id") int id, Model model) {
        model.addAttribute("imgs", imgTechRepository.findAllByTechId(id));
        model.addAttribute("tech", repository.getOne(id));
        return "tech";
    }

    @GetMapping("/techs/Smartphone")
    public String smartphone(Model model, @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("page", repository.getAllByName("[A-Za-zА-Яа-я0-9-./]*смартфон[A-Za-zА-Яа-я0-9-./]*", pageable));
        model.addAttribute("url", "/techs/Smartphone");
        return "techs";
    }

    @GetMapping("/techs/Tablet")
    public String tablet(Model model, @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("page", repository.getAllByName("[A-Za-zА-Яа-я0-9-./]*планшет[A-Za-zА-Яа-я0-9-./]*", pageable));
        model.addAttribute("url", "/techs/Tablet");
        return "techs";
    }
}
