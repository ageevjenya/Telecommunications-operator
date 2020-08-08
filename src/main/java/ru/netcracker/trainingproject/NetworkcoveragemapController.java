package ru.netcracker.trainingproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;
@Controller
public class NetworkcoveragemapController {

    @GetMapping("/networkcoveragemap")
    public String coveragemap(Map<String, Object> model) {


        return "networkcoveragemap";
    }
}
