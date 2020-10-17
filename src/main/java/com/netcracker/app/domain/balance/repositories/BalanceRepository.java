package com.netcracker.app.domain.balance.repositories;

import com.netcracker.app.domain.balance.entities.AbstractBalance;
import com.netcracker.app.domain.balance.entities.Balance;
import com.netcracker.app.domain.shop.entities.Modem;
import com.netcracker.app.domain.shop.repositories.DevicesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceRepository<E extends AbstractBalance> extends JpaRepository<E, Long> {

}
