package com.netcracker.app.domain.balance.repositories.expenses;

import com.netcracker.app.domain.balance.entities.expenses.AbstractExpenses;
import com.netcracker.app.domain.balance.entities.expenses.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ExpensesRepository<E extends AbstractExpenses> extends JpaRepository<E, Long> {
}
