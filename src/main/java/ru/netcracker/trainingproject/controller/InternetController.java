package ru.netcracker.trainingproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.netcracker.trainingproject.domain.Internet;
import ru.netcracker.trainingproject.domain.User;
import ru.netcracker.trainingproject.repository.InternetRepo;

import javax.transaction.Transactional;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/internet")
public class InternetController {
    @Autowired
    private InternetRepo internetRepository;

    @GetMapping
    public String intenet(@RequestParam(required = false, defaultValue = "") String filter, Model model) {

        Iterable<Internet> internetRepositorys;
        if (filter != null && !filter.isEmpty()) {
            internetRepositorys = internetRepository.findByPack(filter);
        } else {
            internetRepositorys = internetRepository.findAll();
        }

        model.addAttribute("internetpacks", internetRepositorys);
        model.addAttribute("filter", filter);
        model.addAttribute("deleteIdCheck", "");
        return "internet";
    }

    @PostMapping
    public String add(@RequestParam String pack, @RequestParam String price, Model model) {
        Internet internet = new Internet(pack, price);
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
            @RequestParam(required = false) String pack,
            @RequestParam(required = false) String price,
            @RequestParam Map<String, String> form,
            @RequestParam("packId") Internet internet, Model model) {
        if (internet != null) {
            if (!pack.isEmpty()) {
                internet.setPack(pack);
            }
            if (!price.isEmpty()) {
                internet.setCost(price);
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
