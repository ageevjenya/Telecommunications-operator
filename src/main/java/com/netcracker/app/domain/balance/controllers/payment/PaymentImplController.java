package com.netcracker.app.domain.balance.controllers.payment;

import com.netcracker.app.domain.balance.services.payment.PaymentImplService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
@Controller
public class PaymentImplController {
    private final PaymentImplService service;

    public PaymentImplController(PaymentImplService service) {
        this.service = service;
    }

    @Transactional
    @GetMapping("payment")
    public String payment(Model model) {
        model.addAttribute("payment", service.getAll());
        return "payment";
    }


}
