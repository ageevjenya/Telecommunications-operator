package com.netcracker.app.domain.balance.controllers;
import com.netcracker.app.domain.balance.entities.Balance;
import com.netcracker.app.domain.balance.repositories.BalanceRepo;
import com.netcracker.app.domain.balance.services.BalanceImplService;
import com.netcracker.app.domain.users.entities.User;
import com.netcracker.app.domain.users.repositories.UserRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;
import java.util.Map;

@Controller
@RequestMapping("/balance")
public class BalanceImplController {
    private final BalanceImplService service;
    private final UserRepo userRepo;
    private final BalanceRepo balanceRepo;

    public BalanceImplController(BalanceImplService service, UserRepo userRepo, BalanceRepo balanceRepo) {
        this.service = service;
        this.userRepo = userRepo;
        this.balanceRepo = balanceRepo;
    }

    @Transactional
    @GetMapping
    public String getBalance(Model model) {
        User user = userRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        Balance balance = null;
        if (user != null) { balance = user.getBalance();
        }

        model.addAttribute("balance", balance);
        return "personalArea";
    }

    @Transactional
    @PostMapping("/save")
    public String saveBalance(@RequestParam (required = false,defaultValue = "0.0") double money) {
        User user = userRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        if (user == null) {
            return "login";
        }

        Balance balance = balanceRepo.getOne(user.getBalance().getId());
        service.saveBalance(money,balance.getId());
        return "redirect:/personalArea";
    }
}

