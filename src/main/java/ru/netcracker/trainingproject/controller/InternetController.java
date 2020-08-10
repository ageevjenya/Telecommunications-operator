package ru.netcracker.trainingproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.netcracker.trainingproject.domain.Internet;
import ru.netcracker.trainingproject.repository.InternetRepo;

import javax.transaction.Transactional;
import java.util.Map;
import java.util.Optional;

@Controller
public class InternetController {
    @Autowired
    private InternetRepo internetRepository;

    @GetMapping("/internet")
    public String intenet(String name, Map<String, Object> model) {
        Iterable<Internet> internetRepositorys = internetRepository.findAll();
        model.put("packinternet", internetRepositorys);
        model.put("deleteIdCheck", "");
        return "internet";
    }

    @PostMapping("/internet/add")
    public String add(@RequestParam String pack, @RequestParam String price, Map<String, Object> model) {
        Internet intetyInternet = new Internet(pack, price);
        internetRepository.save(intetyInternet);
        Iterable<Internet> internetRepositorys = internetRepository.findAll();
        model.put("packinternet", internetRepositorys);
        model.put("deleteIdCheck", "");
        return "internet";
    }

    @PostMapping("/internet/filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {

        Iterable<Internet> internetRepositorys;
        if (filter != null && !filter.isEmpty()) {
            internetRepositorys = internetRepository.findByPack(filter);
        } else {
            internetRepositorys = internetRepository.findAll();
        }

        model.put("packinternet", internetRepositorys);
        model.put("deleteIdCheck", "");
        return "internet";
    }

    @Transactional
    @PostMapping("/internet/deletePack")
    public String deleteManager(@RequestParam Integer packId, Map<String, Object> model) {

        Optional<Internet> packInternet = internetRepository.findById(packId);

        if (!packInternet.isPresent()) {
            model.put("deleteIdCheck", "No pack internet with such index!");
        } else {
            internetRepository.deleteById(packId);
            model.put("deleteIdCheck", "");
        }
        Iterable<Internet> internetRepositorys = internetRepository.findAll();
        model.put("packinternet", internetRepositorys);

        return "internet";
    }

    @Transactional
    @PostMapping("/internet/updatePack")
    public String updateCourier(@RequestParam Integer packId,
                                @RequestParam(required = false) String pack,
                                @RequestParam(required = false) String price,
                                Map<String, Object> model) {
        if (packId!=null){
            Optional<Internet> packInternet = internetRepository.findById(packId);
            if (packInternet.isPresent()) {
                if (!pack.isEmpty()) {
                    internetRepository.setPackFor(pack, packId);
                }
                if (!price.isEmpty()) {
                    internetRepository.setPriceFor(price, packId);
                }
            }
        }
        Iterable<Internet> internetRepositorys = internetRepository.findAll();

        model.put("packinternet", internetRepositorys);
        model.put("deleteIdCheck", "");
        return "internet";
    }




}
