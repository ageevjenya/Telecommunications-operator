package com.netcracker.app.info.entities.contacts;

public interface Contacts {
    String getAddress();

    void setAddress(String address) throws Exception;

    String getPhone();

    void setPhone(String phone);

    String getWorkHours();

    void setWorkHours(String workHours);
}
