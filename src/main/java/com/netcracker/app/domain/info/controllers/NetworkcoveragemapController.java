package com.netcracker.app.domain.info.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.netcracker.app.domain.info.entities.networkcoveragemap.PointAcces;
import com.netcracker.app.domain.info.entities.networkcoveragemap.TypePointAcces;
import com.netcracker.app.domain.info.repositories.PointAccesRepo;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/networkcoveragemap")
public class NetworkcoveragemapController {

    @Autowired
    private PointAccesRepo pointAccesRepo;

    @GetMapping
    public String coveragemap(Model model) {
//        PointAcces.newSomePoint(pointAccesRepo);
//        List[] types;
//        for (TypePointAcces type: TypePointAcces.values()
//             ) {type.setState(true);
//
//
//        }
        Iterable<PointAcces> pointsacces = pointAccesRepo.findAll();
        model.addAttribute("typepoints", TypePointAcces.values());
        model.addAttribute("typepointschecked", TypePointAcces.values());
        model.addAttribute("pointsacces", pointsacces);
        return "networkcoveragemap";
    }

    @PostMapping
    public String coveragemap(@RequestParam Map<String, String> form,
                              Model model) {

        Set<String> typePoint = Arrays.stream(TypePointAcces.values())
                .map(TypePointAcces::name)
                .collect(Collectors.toSet());

        Set<TypePointAcces> typePointChecked = new HashSet<>();
        List<String> ListTypePoint = new ArrayList<>();
        for (String key : form.keySet()) {
            if (typePoint.contains(key)) {
                ListTypePoint.add(TypePointAcces.valueOf(key).toString());
            }
        }

//        System.out.println(ListTypePoint.toString());

        Iterable<PointAcces> pointsacces = pointAccesRepo.selectPointAcces(ListTypePoint);
        model.addAttribute("typepoints", TypePointAcces.values());
        model.addAttribute("typepointschecked", ListTypePoint);
        model.addAttribute("pointsacces", pointsacces);
        return "networkcoveragemap";
    }
}
