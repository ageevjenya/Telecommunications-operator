package com.netcracker.app.domain.balance.services;
import com.netcracker.app.domain.balance.entities.Balance;
import com.netcracker.app.domain.balance.repositories.BalanceRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalanceImplService extends AbstractBalanceService<Balance> {
    private final BalanceRepo repository;

    public BalanceImplService(BalanceRepo balanceRepo) {
        this.repository = balanceRepo;
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    public Balance getById(Long id) {
        return repository.getById(id);
    }

    @Override
    public List<Balance> getAll() {
        return repository.findAll();
    }

    @Override
    public void updateBalance(double money, Long id) throws Exception {
        if(repository.existsById(id)) {
            Balance balance = repository.getById(id);
            if(money <= balance.getMoney()) {
                balance.setMoney(balance.getMoney() - money);
                repository.saveAndFlush(balance);
            } else
                throw new Exception("Недостаточно средств на счете");
        }
    }

    @Override
    public void saveBalance(double money, Long id) {
        if(repository.existsById(id)) {
            Balance balance = repository.getById(id);
            balance.setMoney(balance.getMoney() + money);
            repository.saveAndFlush(balance);
        }
    }

    @Override
    public void add(Balance balance) {
        repository.saveAndFlush(balance);
    }
}
