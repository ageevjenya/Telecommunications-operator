package com.netcracker.app.domain.shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewOrderController {
    @GetMapping("/newOrder")
    public String newOrder() {
        return "newOrder";
    }
}
