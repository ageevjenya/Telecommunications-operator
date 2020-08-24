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
import java.util.List;
import java.util.Map;
import java.util.Set;

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
