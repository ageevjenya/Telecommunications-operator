package com.netcracker.app.domain.balance.repositories.expenses;

import com.netcracker.app.domain.balance.entities.Balance;
import com.netcracker.app.domain.balance.entities.expenses.Expenses;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpensesRepo extends ExpensesRepository<Expenses> {
    @Query("select e from Expenses e where e.id = :id")
    Balance getById(@Param("id") Long id);
}
