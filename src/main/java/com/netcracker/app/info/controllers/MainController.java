package com.netcracker.app.info.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.netcracker.app.info.entities.PointAcces;
import com.netcracker.app.info.repositories.PointAccesRepo;


@Controller
public class MainController {
    @Autowired
    private PointAccesRepo pointAccesRepo;

    @GetMapping("/")
    public String main(Model model) {

        Iterable<PointAcces> pointsacces = pointAccesRepo.findAll();

        model.addAttribute("pointsacces", pointsacces);
        return "main";
    }


}
