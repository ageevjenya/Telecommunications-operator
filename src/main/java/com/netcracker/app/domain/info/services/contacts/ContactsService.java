package com.netcracker.app.domain.info.services.contacts;

import com.netcracker.app.domain.info.entities.contacts.Contacts;

public interface ContactsService<E extends Contacts> {
    void add(E e);
    boolean existsById(int id);
    void deleteById(int id);
    Iterable<E> getAll();
}
