package com.netcracker.app.domain.tariffs.services;

import com.netcracker.app.domain.tariffs.entities.Tariff;

import java.util.List;

public interface TariffService<E extends Tariff> {

    void add(E e);
    void delete(int id) throws Exception;
    Iterable<E> getAllByName(String name);
    List<E> getAll();
    E getById(int id);
    void updateName(String name, int id);
    void updatePriceOfMonth(double priceOfMonth, int id);
    void updateDescription(String description, int id);
    void updateGbInternet(double gbInternet, int id);
    boolean existsById(int id);
}