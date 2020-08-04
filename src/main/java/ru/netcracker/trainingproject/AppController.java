package ru.netcracker.trainingproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.netcracker.trainingproject.domain.IntetyInternet;
import ru.netcracker.trainingproject.repository.InternetRepository;

import javax.transaction.Transactional;
import java.util.Map;
import java.util.Optional;

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
        model.put("deleteIdCheck", "");
        return "main";
    }

    @PostMapping
    public String add(@RequestParam String pack, @RequestParam String price, Map<String, Object> model) {
        IntetyInternet intetyInternet = new IntetyInternet(pack, price);
        internetRepository.save(intetyInternet);
        Iterable<IntetyInternet> internetRepositorys = internetRepository.findAll();
        model.put("packinternet", internetRepositorys);
        model.put("deleteIdCheck", "");
        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {

        Iterable<IntetyInternet> internetRepositorys;
        if (filter != null && !filter.isEmpty()) {
            internetRepositorys = internetRepository.findByPack(filter);
        } else {
            internetRepositorys = internetRepository.findAll();
        }

        model.put("packinternet", internetRepositorys);
        model.put("deleteIdCheck", "");
        return "main";
    }

    @Transactional
    @PostMapping("deletePack")
    public String deleteManager(@RequestParam Integer packId, Map<String, Object> model) {

        Optional<IntetyInternet> packInternet = internetRepository.findById(packId);

        if (!packInternet.isPresent()) {
            model.put("deleteIdCheck", "No pack internet with such index!");
        } else {
            internetRepository.deleteById(packId);
            model.put("deleteIdCheck", "");
        }
        model.put("packinternet", internetRepository.findAll());

        return "main";
    }

    @Transactional
    @PostMapping("updatePack")
    public String updateCourier(@RequestParam Integer packId,
                                @RequestParam(required = false) String pack,
                                @RequestParam(required = false) String price,
                                Map<String, Object> model) {
        Optional<IntetyInternet> packInternet = internetRepository.findById(packId);
        if (packInternet.isPresent()) {
            if (!pack.isEmpty()) {
                internetRepository.setPackFor(pack, packId);
            }
            if (!price.isEmpty()) {
                internetRepository.setPriceFor(price, packId);
            }
        }


        model.put("packinternet", internetRepository.findAll());
        model.put("deleteIdCheck", "");
        return "main";
    }

    @GetMapping("networkcoveragemap")
    public String coveragemap(Map<String, Object> model) {


        return "networkcoveragemap";
    }
}
