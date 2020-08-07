package ru.netcracker.trainingproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.netcracker.trainingproject.domain.IntetyInternet;

import java.util.Map;


@Controller
public class MainController {

    @GetMapping
    public String main(Map<String, Object> model) {

        return "main";
    }
}
