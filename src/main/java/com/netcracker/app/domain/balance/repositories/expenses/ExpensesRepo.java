package com.netcracker.app.domain.balance.repositories.expenses;

import com.netcracker.app.domain.balance.entities.expenses.Expenses;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ExpensesRepo extends ExpensesRepository<Expenses> {
    @Query("select e from Expenses e where e.id = :id")
    Expenses getById(@Param("id") Long id);
    @Query(value = "SELECT * FROM EXPENSES e WHERE u.id = :id",nativeQuery = true)
    List<Expenses> findAllExpenses(@Param("id") Long id);
}
