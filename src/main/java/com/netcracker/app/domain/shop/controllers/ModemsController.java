package com.netcracker.app.domain.shop.controllers;

import com.netcracker.app.domain.shop.entities.Modem;
import com.netcracker.app.domain.shop.repositories.ImgModemRepository;
import com.netcracker.app.domain.shop.repositories.ModemRepository;
import com.netcracker.app.domain.shop.services.ModemService;
import org.springframework.data.domain.Page;
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
//@RequestMapping("/modems")
public class ModemsController {
    private final ModemService service;
    private final ImgModemRepository imgModemRepository;
    private final ModemRepository modemRepository;

    public ModemsController(ModemService service, ImgModemRepository imgModemRepository, ModemRepository modemRepository) {
        this.service = service;
        this.imgModemRepository = imgModemRepository;
        this.modemRepository = modemRepository;
    }

    @GetMapping("/modems")
    public String modems(@RequestParam(required = false) String filter,
                         Model model,
                         @PageableDefault(sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Modem> page;
        if (filter != null && !filter.isEmpty()) {
            page = modemRepository.getAllByName(filter, pageable);
        } else {
            page = modemRepository.findAll(pageable);
        }
        model.addAttribute("page", page);
        model.addAttribute("url", "/modems");
        model.addAttribute("filter", filter);
        return "modems";
    }

    @GetMapping("/modems/{id}")
    public String all(@PathVariable("id") int id, Model model) {
        model.addAttribute("imgs", imgModemRepository.findAllByModemId(id));
        model.addAttribute("modem", modemRepository.getOne(id));
        return "modem";
    }

    @GetMapping("/modems/Modem")
    public String modem(Model model, @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("page", modemRepository.getAllByName("[A-Za-zА-Яа-я0-9-./]*модем[A-Za-zА-Яа-я0-9-./]*", pageable));
        model.addAttribute("url", "/modems/Modem");
        return "modems";
    }

    @GetMapping("/modems/Router")
    public String router(Model model, @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("page", modemRepository.getAllByName("[A-Za-zА-Яа-я0-9-./]*роутер[A-Za-zА-Яа-я0-9-./]*", pageable));
        model.addAttribute("url", "/modems/Router");
        return "modems";
    }
}
