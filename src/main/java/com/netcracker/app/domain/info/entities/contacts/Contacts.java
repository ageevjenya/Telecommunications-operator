package com.netcracker.app.domain.info.entities.contacts;

import java.util.List;

public interface Contacts {
    String getAddress();

    void setAddress(String address) throws Exception;

    String getPhone();

    void setPhone(String phone);

    String getWorkHours();

    void setWorkHours(String workHours);
}
