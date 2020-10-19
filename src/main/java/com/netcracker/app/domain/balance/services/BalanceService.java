package com.netcracker.app.domain.balance.services;

import com.netcracker.app.domain.balance.entities.AbstractBalance;

import java.util.List;

public interface BalanceService <E extends AbstractBalance> {
    boolean existsById(Long id);
    E getById(Long id);
    List<E> getAll();
    void updateBalance(double balance, Long id) throws Exception;
    void saveBalance(double balance, Long id);
    void add(E e);
}
