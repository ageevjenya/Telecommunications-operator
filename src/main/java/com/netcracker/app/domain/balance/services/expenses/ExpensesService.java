package com.netcracker.app.domain.balance.services.expenses;

import com.netcracker.app.domain.balance.entities.expenses.AbstractExpenses;
import com.netcracker.app.domain.users.entities.User;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

public interface ExpensesService <E extends AbstractExpenses> {
    boolean existsById(Long id);
    List<E> getAll();
    void add(E e);
    E getById(Long id);
    void updateExpenses(double balance, Calendar date, String description, Long id, User userId);
}
