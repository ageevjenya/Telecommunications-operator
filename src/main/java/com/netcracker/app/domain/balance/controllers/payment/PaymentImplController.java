package com.netcracker.app.domain.balance.controllers.payment;

import com.netcracker.app.domain.balance.entities.Balance;
import com.netcracker.app.domain.balance.repositories.BalanceRepo;
import com.netcracker.app.domain.balance.services.BalanceImplService;
import com.netcracker.app.domain.balance.services.payment.PaymentImplService;
import com.netcracker.app.domain.users.entities.User;
import com.netcracker.app.domain.users.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
@Controller
public class PaymentImplController {
    private final PaymentImplService service;

    public PaymentImplController(PaymentImplService service) {
        this.service = service;
    }


}
