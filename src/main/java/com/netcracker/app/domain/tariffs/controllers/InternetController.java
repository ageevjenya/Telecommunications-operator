package com.netcracker.app.domain.tariffs.controllers;

import com.netcracker.app.domain.tariffs.entities.TariffHome;
import com.netcracker.app.domain.tariffs.repositories.TariffHomeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/tariffHome")
public class InternetController {

    @Autowired
    private final TariffHomeRepo tariffHomeRepository;

    public InternetController(TariffHomeRepo tariffHomeRepository) {
        this.tariffHomeRepository = tariffHomeRepository;
    }

    @GetMapping
    public String internet(@RequestParam(required = false, defaultValue = "") String filter, Model model) {

        Iterable<TariffHome> internetRepositorys;
        if (filter != null && !filter.isEmpty()) {
            internetRepositorys = tariffHomeRepository.findByName(filter);
        } else {
            internetRepositorys = tariffHomeRepository.findAll();
        }

        model.addAttribute("internetpacks", internetRepositorys);
        model.addAttribute("filter", filter);
        model.addAttribute("deleteIdCheck", "");
        return "tariffHome";
    }

    @PostMapping("/add")
    public String add(@RequestParam String name,
                      @RequestParam double priceOfMonth,
                      @RequestParam double gbInternet,
                      @RequestParam String description,
                      Model model) {
        TariffHome tariffHome = new TariffHome(name, priceOfMonth, gbInternet, description);
        tariffHomeRepository.save(tariffHome);
        Iterable<TariffHome> internetRepositorys = tariffHomeRepository.findAll();
        model.addAttribute("internetpacks", internetRepositorys);
        model.addAttribute("deleteIdCheck", "");
        model.addAttribute("filter", "");
        return "tariffHome";
    }



    @PostMapping("/delete")
    public String delete(@RequestParam Integer packId, Model model) {

        Optional<TariffHome> packInternet = tariffHomeRepository.findById(packId);

        if (!packInternet.isPresent()) {
            model.addAttribute("deleteIdCheck", "No pack internet with such index!");
        } else {
            tariffHomeRepository.deleteById(packId);
            model.addAttribute("deleteIdCheck", "");
        }
        Iterable<TariffHome> internetRepositorys = tariffHomeRepository.findAll();
        model.addAttribute("internetpacks", internetRepositorys);
        model.addAttribute("filter", "");

        return "tariffHome";
    }


    @PostMapping("/update")
    public String update(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) double priceOfMonth,
            @RequestParam(required = false) double gbOfInternet,
            @RequestParam(required = false) String description,
            @RequestParam Map<String, String> form,
            @RequestParam("packId") TariffHome tariffHome, Model model) {
        if (tariffHome != null) {
            if (!name.isEmpty()) {
                tariffHome.setName(name);
            }
            if (priceOfMonth != 0) {
                tariffHome.setPriceOfMonth(priceOfMonth);
            }
            if (gbOfInternet != 0) {
                tariffHome.setGbInternet(gbOfInternet);
            }
            if (!description.isEmpty()) {
                tariffHome.setDescription(description);
            }
        }
        tariffHomeRepository.save(tariffHome);
        Iterable<TariffHome> internetRepositorys = tariffHomeRepository.findAll();
        model.addAttribute("internetpacks", internetRepositorys);
        model.addAttribute("filter", "");
        model.addAttribute("deleteIdCheck", "");
        return "tariffHome";
    }


}
