package com.netcracker.app.domain.tariffs.controllers;

import com.netcracker.app.domain.tariffs.repositories.InternetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.netcracker.app.domain.tariffs.entities.Internet;

import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/internet")
public class InternetController {

    private final InternetRepo internetRepository;

    public InternetController(InternetRepo internetRepository) {
        this.internetRepository = internetRepository;
    }

    @GetMapping
    public String internet(@RequestParam(required = false, defaultValue = "") String filter, Model model) {

        Iterable<Internet> internetRepositorys;
        if (filter != null && !filter.isEmpty()) {
            internetRepositorys = internetRepository.findByName(filter);
        } else {
            internetRepositorys = internetRepository.findAll();
        }

        model.addAttribute("internetpacks", internetRepositorys);
        model.addAttribute("filter", filter);
        model.addAttribute("deleteIdCheck", "");
        return "internet";
    }

    @PostMapping
    public String add(@RequestParam String name,
                      @RequestParam double priceOfMonth,
                      @RequestParam double gbInternet,
                      @RequestParam String description,
                      Model model) {
        Internet internet = new Internet(name, priceOfMonth, gbInternet, description);
        internetRepository.save(internet);
        Iterable<Internet> internetRepositorys = internetRepository.findAll();
        model.addAttribute("internetpacks", internetRepositorys);
        model.addAttribute("deleteIdCheck", "");
        model.addAttribute("filter", "");
        return "internet";
    }



    @PostMapping("/delete")
    public String delete(@RequestParam Integer packId, Model model) {

        Optional<Internet> packInternet = internetRepository.findById(packId);

        if (!packInternet.isPresent()) {
            model.addAttribute("deleteIdCheck", "No pack internet with such index!");
        } else {
            internetRepository.deleteById(packId);
            model.addAttribute("deleteIdCheck", "");
        }
        Iterable<Internet> internetRepositorys = internetRepository.findAll();
        model.addAttribute("internetpacks", internetRepositorys);
        model.addAttribute("filter", "");

        return "internet";
    }


    @PostMapping("/update")
    public String update(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) double priceOfMonth,
            @RequestParam(required = false) double gbInternet,
            @RequestParam(required = false) String description,
            @RequestParam Map<String, String> form,
            @RequestParam("packId") Internet internet, Model model) {
        if (internet != null) {
            if (!name.isEmpty()) {
                internet.setName(name);
            }
            if (priceOfMonth != 0) {
                internet.setPriceOfMonth(priceOfMonth);
            }
            if (gbInternet != 0) {
                internet.setGbInternet(gbInternet);
            }
            if (!description.isEmpty()) {
                internet.setDescription(description);
            }
        }
        internetRepository.save(internet);
        Iterable<Internet> internetRepositorys = internetRepository.findAll();
        model.addAttribute("internetpacks", internetRepositorys);
        model.addAttribute("filter", "");
        model.addAttribute("deleteIdCheck", "");
        return "internet";
    }


}
