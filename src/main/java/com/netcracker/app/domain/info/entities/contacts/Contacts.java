package com.netcracker.app.domain.info.entities.contacts;

public interface Contacts {
    String getPointName();

    void setPointName(String pointName);

    String getAddress();

    void setAddress(String address) throws Exception;

    String getPhone();

    void setPhone(String phone);

    String getWorkHours();

    void setWorkHours(String workHours);
}
