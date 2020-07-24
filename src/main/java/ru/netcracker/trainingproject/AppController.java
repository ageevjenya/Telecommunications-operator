package ru.netcracker.trainingproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.netcracker.trainingproject.domain.IntetyInternet;
import ru.netcracker.trainingproject.repository.InternetRepository;

import java.util.Map;

@Controller
public class AppController {
    @Autowired
    private InternetRepository internetRepository;

    @GetMapping("/internet")
    public String intenet(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
                          Map<String, Object> model) {
        model.put("name", name);
        return "internet";
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<IntetyInternet> internetRepositorys = internetRepository.findAll();
        model.put("packinternet", internetRepositorys);
        return "main";
    }

    @PostMapping
    public String add(@RequestParam String pack, @RequestParam String price, Map<String, Object> model) {
        IntetyInternet intetyInternet = new IntetyInternet(pack, price);
        internetRepository.save(intetyInternet);
        Iterable<IntetyInternet> internetRepositorys = internetRepository.findAll();
        model.put("packinternet", internetRepositorys);
        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {

        Iterable<IntetyInternet> internetRepositorys;
        if (filter != null && !filter.isEmpty()) {
            internetRepositorys = internetRepository.findByPack(filter);
        }else{internetRepositorys = internetRepository.findAll();
        }

        model.put("packinternet", internetRepositorys);
        return "main";
    }
}
