package com.netcracker.app.domain.shop.services;

import com.netcracker.app.domain.shop.entities.Devices;

import java.util.List;

public interface DevicesService<E extends Devices> {
    void add(E e);
    void delete(int id);
    Iterable<E> getAllByName(String name);
    List<E> getAll();
    E getById(int id);
    void updateName(String name, int id) throws Exception;
    void updatePrice(double price, int id) throws Exception;
    void updateDescription(String description, int id) throws Exception;
    void updateShortDescription(String shortDescription, int id) throws Exception;
    void updateSpecifications(String specifications, int id) throws Exception;
    void updateImgUrl(String imgUrl, int id) throws Exception;
    boolean existsById(int id);
}
