package com.netcracker.app.domain.info.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.netcracker.app.domain.info.entities.PointAcces;
import com.netcracker.app.domain.info.entities.TypePointAcces;
import com.netcracker.app.domain.info.repositories.PointAccesRepo;

import java.util.Map;

@Controller
@RequestMapping("/networkcoveragemap")
public class NetworkcoveragemapController {

    @Autowired
    private PointAccesRepo pointAccesRepo;

    @GetMapping
    public String coveragemap(Model model) {
        //PointAcces.newSomePoint(pointAccesRepo);
//        List[] types;
//        for (TypePointAcces type: TypePointAcces.values()
//             ) {type.setState(true);
//
//
//        }
        Iterable<PointAcces> pointsacces = pointAccesRepo.findAll();
        model.addAttribute("typepoints", TypePointAcces.values());
        model.addAttribute("pointsacces", pointsacces);
        return "networkcoveragemap";
    }

    @PostMapping
    public String coveragemap(@RequestParam(value = "G2", required = false) boolean G2,
                              @RequestParam(value = "G3", required = false) boolean G3,
                              @RequestParam(value = "G4", required = false) boolean G4,
                              @RequestParam Map<String, String> form,
                              Model model) {
        StringBuffer type = null;
        if (G2) {
            type.append("G2");
        }
        if (G3) {
            type.append("G3");
        }
        if (G4) {
            type.append("G4");
        }
//        Set<TypePointAcces> setTypePoint = null;//= Arrays.stream(TypePointAcces.values());
//        for (String key : form.keySet()) {
//            if (setTypePoint.contains(key)) {
//                setTypePoint.add(TypePointAcces.valueOf(key));
//            }
//        }
        Iterable<PointAcces> pointsacces = null;
        if (type!=null){
        pointsacces = pointAccesRepo.selectPointAcces(type.toString());}

        //Iterable<PointAcces> pointsacces = pointAccesRepo.findAll();
        model.addAttribute("typepoints", TypePointAcces.values());
        model.addAttribute("pointsacces", pointsacces);
        return "networkcoveragemap";
    }
}
