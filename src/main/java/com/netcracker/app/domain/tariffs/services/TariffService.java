package com.netcracker.app.domain.tariffs.services;

import com.netcracker.app.domain.tariffs.entities.Tariff;

import java.util.List;

public interface TariffService<E extends Tariff> {

    void add(E e);
    void delete(Long id) throws Exception;
    Iterable<E> getAllByName(String name);
    List<E> getAll();
    E getById(Long id);
    void updateName(String name, Long id);
    void updatePriceOfMonth(double priceOfMonth, Long id);
    void updateDescription(String description, Long id);
    void updateGbInternet(double gbInternet, Long id);
    boolean existsById(Long id);
}