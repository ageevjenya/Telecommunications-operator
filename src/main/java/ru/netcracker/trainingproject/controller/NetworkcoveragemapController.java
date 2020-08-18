package ru.netcracker.trainingproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.netcracker.trainingproject.domain.Internet;
import ru.netcracker.trainingproject.domain.PointAcces;
import ru.netcracker.trainingproject.domain.Role;
import ru.netcracker.trainingproject.domain.TypePointAcces;
import ru.netcracker.trainingproject.repository.PointAccesRepo;
import ru.netcracker.trainingproject.repository.UserRepo;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/networkcoveragemap")
public class NetworkcoveragemapController {

    @Autowired
    private PointAccesRepo pointAccesRepo;

    @GetMapping
    public String coveragemap(Model model) {
        Iterable<PointAcces> pointsacces = pointAccesRepo.findAll();
        model.addAttribute("typepoints", TypePointAcces.values());
        model.addAttribute("pointsacces", pointsacces);
        return "networkcoveragemap";
    }
    @PostMapping("/filter")
    public String coveragemap(@RequestParam Map<String, String> form, Model model) {

        Set<TypePointAcces> setTypePoint = null  ;//= Arrays.stream(TypePointAcces.values());
        for (String key : form.keySet()) {
            if (setTypePoint.contains(key)) {
                setTypePoint.add(TypePointAcces.valueOf(key));
            }
        }
//        Iterable<PointAcces> pointsacces = pointAccesRepo.selectPointAcces(setTypePoint);
        Iterable<PointAcces> pointsacces = pointAccesRepo.findAll();
        model.addAttribute("typepoints", TypePointAcces.values());
        model.addAttribute("pointsacces", pointsacces);
        return "networkcoveragemap";
    }
}
