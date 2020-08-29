package com.netcracker.app.domain.info.entities.contacts;

import javax.persistence.Entity;

@Entity
public class ContactsImpl extends AbstractContacts {
    public ContactsImpl(String pointName, String address, String phone, String workHours) throws Exception {
        super(pointName, address, phone, workHours);
    }

    public ContactsImpl(){
        super();
    }

    public static String[] getFieldsNames() {
        String[] names = {"pointName", "address", "phone", "workHours"};
        return names;
    }
}
