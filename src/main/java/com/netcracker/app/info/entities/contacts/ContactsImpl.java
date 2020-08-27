package com.netcracker.app.info.entities.contacts;

import javax.persistence.Entity;

@Entity
public class ContactsImpl extends AbstractContacts {
    public ContactsImpl(String address, String phone, String workHours) throws Exception {
        super(address, phone, workHours);
    }

    public ContactsImpl(){
        super();
    }

    public static String[] getFieldsNames() {
        String[] names = {"address", "phone", "workHours"};
        return names;
    }
}
