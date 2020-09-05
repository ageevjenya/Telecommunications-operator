package com.netcracker.app.domain.tariffs.services;

import com.netcracker.app.domain.tariffs.repositories.TariffRepository;
import com.netcracker.app.domain.tariffs.entities.Tariff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public abstract class AbstractTariffService<E extends Tariff> implements TariffService<E> {

    protected final TariffRepository repository;

    @Autowired
    public AbstractTariffService(TariffRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean existsById(int id) {
        return repository.existsById(id);
    }

    @Override
    public void add(E e) {
        repository.saveAndFlush(e);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<E> getAll() {
        return repository.findAll();
    }
}
