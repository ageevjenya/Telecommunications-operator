package com.netcracker.app.domain.balance.controllers.expenses;

import com.netcracker.app.domain.balance.services.expenses.ExpensesImplService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;

@Controller
public class ExpensesImplController {
    private final ExpensesImplService service;

    public ExpensesImplController(ExpensesImplService service) {
        this.service = service;
    }

    @Transactional
    @GetMapping("expenses")
    public String expenses(Model model) {
        model.addAttribute("expenses", service.getAll());
        return "expenses";
    }
}
