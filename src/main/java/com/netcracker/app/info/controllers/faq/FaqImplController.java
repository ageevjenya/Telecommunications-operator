package com.netcracker.app.info.controllers.faq;

import com.netcracker.app.info.services.faq.FaqImplService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;

@Controller
public class FaqImplController {
    private final FaqImplService service;

    public FaqImplController(FaqImplService service) {
        this.service = service;
    }

    @Transactional
    @GetMapping("faq")
    public String faq(Model model) {
        model.addAttribute("faq", service.getAll());
        return "faq";
    }
}
