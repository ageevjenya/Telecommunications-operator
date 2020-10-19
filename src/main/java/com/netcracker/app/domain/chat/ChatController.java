package com.netcracker.app.domain.chat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chatQuestionEdit")
public class ChatController {


    @GetMapping
    public String requests(Model model) {
        return "chatQuestionEdit";
    }

}
