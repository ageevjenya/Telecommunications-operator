package com.netcracker.app.domain.personalArea;

import com.netcracker.app.domain.users.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/personalArea")
public class personalAreaController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping
    public String personalArea(Model model) {
//        model.addAttribute("users", userRepo.findAll());
        return "personalArea";
    }


}
