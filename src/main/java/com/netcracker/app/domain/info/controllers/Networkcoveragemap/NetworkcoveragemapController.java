package com.netcracker.app.domain.info.controllers.Networkcoveragemap;


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
//        PointAcces.newSomePoint(pointAccesRepo); //function add 100 new random point

        Set<TypePointAcces> typepointschecked= new HashSet<TypePointAcces>();
        typepointschecked.add(TypePointAcces.G2);
        Iterable<PointAcces> pointsacces = pointAccesRepo.findAll();
        model.addAttribute("typepoints", TypePointAcces.values());
        model.addAttribute("typepointschecked", typepointschecked);
        model.addAttribute("pointsacces", pointsacces);
        return "networkcoveragemap";
    }


}
