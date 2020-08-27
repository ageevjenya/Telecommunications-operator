package com.netcracker.app.info.services.contacts;

import com.netcracker.app.info.entities.contacts.ContactsImpl;
import com.netcracker.app.info.repositories.contacts.ContactsImplRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactsServiceImpl extends AbstractContactsService<ContactsImpl> {
    private ContactsImplRepository repository;

    @Autowired
    public ContactsServiceImpl(ContactsImplRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public void updateAddress(String address, int id) throws Exception {
        if (repository.existsById(id) && address != null) {
            ContactsImpl companyInfo = repository.getOne(id);
            companyInfo.setAddress(address);
            repository.saveAndFlush(companyInfo);
        }
    }

    public void updatePhone(String phone, int id) {
        if (repository.existsById(id) && phone != null) {
            ContactsImpl companyInfo = repository.getOne(id);
            companyInfo.setPhone(phone);
            repository.saveAndFlush(companyInfo);
        }
    }

    public void updateWorkHours(String workHours, int id) {
        if (repository.existsById(id) && workHours != null) {
            ContactsImpl companyInfo = repository.getOne(id);
            companyInfo.setWorkHours(workHours);
            repository.saveAndFlush(companyInfo);
        }
    }
}
