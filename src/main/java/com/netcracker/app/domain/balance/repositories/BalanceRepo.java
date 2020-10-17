package com.netcracker.app.domain.balance.repositories;

import com.netcracker.app.domain.balance.entities.Balance;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceRepo extends BalanceRepository<Balance> {
    @Query("select b from Balance b where b.id = :id")
    Balance getById(@Param("id") Long id);
}
