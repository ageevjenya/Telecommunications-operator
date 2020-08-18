package ru.netcracker.trainingproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.netcracker.trainingproject.domain.Internet;
import ru.netcracker.trainingproject.domain.PointAcces;
import ru.netcracker.trainingproject.domain.TypePointAcces;
import ru.netcracker.trainingproject.repository.PointAccesRepo;

import java.util.Map;


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
