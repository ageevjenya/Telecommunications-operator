package com.netcracker.app.domain.index;

import com.netcracker.app.domain.info.entities.networkcoveragemap.PointAcces;
import com.netcracker.app.domain.info.repositories.PointAccesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class index {

    @Autowired
    private PointAccesRepo pointAccesRepo;

    @GetMapping
    public String index(Model model) {
        Iterable<PointAcces> pointsacces = pointAccesRepo.findAll();
//        model.addAttribute("typepoints", TypePointAcces.values());
        model.addAttribute("pointsacces", pointsacces);
        return "index";
    }


}

