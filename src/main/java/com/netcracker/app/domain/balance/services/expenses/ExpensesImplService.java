package com.netcracker.app.domain.balance.services.expenses;

import com.netcracker.app.domain.balance.entities.expenses.Expenses;
import com.netcracker.app.domain.balance.repositories.expenses.ExpensesRepo;
import com.netcracker.app.domain.users.entities.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

@Service
public class ExpensesImplService extends AbstractExpensesService<Expenses> {
    private final ExpensesRepo repository;


    public ExpensesImplService(ExpensesRepo repository) {
        this.repository = repository;
    }

    @Override
    public void updateExpenses(double price, Calendar date, String description, Long id,User userId){
        if(repository.existsById(id)) {
            Expenses expenses = repository.getById(id);
            expenses.setPrice(price);
            expenses.setActivationDate(date);
            expenses.setDescription(description);
            expenses.setUser(userId);
            repository.saveAndFlush(expenses);
        }
    }

    public void allMobileExpenses(Long id, User userId){
        if(repository.existsById(id)) {
            Expenses expenses = repository.getById(id);

            repository.saveAndFlush(expenses);
        }
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public Expenses getById(Long id) {
        return repository.getById(id);
    }

    @Override
    public List<Expenses> getAll() {
        return repository.findAll();
    }

    @Override
    public void add(Expenses expenses) {
        repository.saveAndFlush(expenses);
    }
}