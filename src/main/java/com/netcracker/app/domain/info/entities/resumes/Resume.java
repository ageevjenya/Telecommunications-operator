package com.netcracker.app.domain.info.entities.resumes;

import java.util.Calendar;

public interface Resume {
    String getFirstName();
    void setFirstName(String firstName) throws Exception;
    String getLastName();
    void setLastName(String lastName) throws Exception;
    String getPhone();
    void setPhone(String phone) throws Exception;
    String getEmail();
    void setEmail(String email) throws Exception;
    String getText();
    void setText(String text) throws Exception;
    Calendar getBirthday();
    void setBirthday(String birthday) throws Exception;
}
