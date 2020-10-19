package com.netcracker.app.domain.balance.services.payment;

import com.netcracker.app.domain.balance.entities.payment.Payment;

public interface PaymentService <E extends Payment> {
    boolean existsById(int id);
    E getById(int id) throws Exception;
    Iterable<E> getAll();
    void updateName(String name, int id) throws Exception;
    void updateSurname(String surname, int id) throws Exception;
    void updateNumber(Integer number, int id) throws Exception;
    void add(E e);
}
