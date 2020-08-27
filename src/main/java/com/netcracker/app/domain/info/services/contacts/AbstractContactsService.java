package com.netcracker.app.domain.info.services.contacts;

import com.netcracker.app.domain.info.entities.contacts.AbstractContacts;
import com.netcracker.app.domain.info.repositories.contacts.ContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractContactsService<E extends AbstractContacts> implements ContactsService<E> {
    private final ContactsRepository contactsRepository;

    @Autowired
    protected AbstractContactsService(ContactsRepository contactsRepository) {
        this.contactsRepository = contactsRepository;
    }

    @Override
    public void add(E e) {
        contactsRepository.saveAndFlush(e);
    }

    @Override
    public void deleteById(int id) {
        if (contactsRepository.existsById(id)) {
            contactsRepository.deleteById(id);
        }
    }

    @Override
    public boolean existsById(int id) { return contactsRepository.existsById(id); }

    @Override
    public Iterable<E> getAll() {
        return contactsRepository.findAll();
    }
}
