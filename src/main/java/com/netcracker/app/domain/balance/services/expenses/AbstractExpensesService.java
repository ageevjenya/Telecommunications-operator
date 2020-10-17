package com.netcracker.app.domain.balance.services.expenses;

import com.netcracker.app.domain.balance.entities.expenses.AbstractExpenses;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractExpensesService <E extends AbstractExpenses> implements ExpensesService<E>  {

}

