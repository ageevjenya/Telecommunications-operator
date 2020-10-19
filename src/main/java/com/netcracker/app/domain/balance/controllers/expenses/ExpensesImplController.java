package com.netcracker.app.domain.balance.controllers.expenses;

import com.netcracker.app.domain.balance.entities.expenses.Expenses;
import com.netcracker.app.domain.balance.services.expenses.ExpensesImplService;
import com.netcracker.app.domain.users.UserService;
import com.netcracker.app.domain.users.repositories.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.util.List;

@Controller
public class ExpensesImplController {
    private final UserRepo userRepo;
    private final ExpensesImplService expensesImplService;
    public ExpensesImplController(UserRepo userRepo, ExpensesImplService expensesImplService) {
        this.userRepo = userRepo;
        this.expensesImplService = expensesImplService;

    }


}
