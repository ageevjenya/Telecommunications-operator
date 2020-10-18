package com.netcracker.app.domain.shop.entities;

import com.netcracker.app.domain.users.entities.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
public class UserOrder {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private LocalDate createdAt;
    private String email;
    private String address;
    private String phone;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt() {
        this.createdAt = LocalDate.now();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
        Pattern pattern = Pattern.compile("\\b[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,4}\\b");
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            this.email = email;
        } else {
            throw new Exception("Incorrect email");
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) throws Exception {
        Pattern pattern = Pattern.compile("^\\s*(?:\\+?(\\d{1,3}))?([-. (]*(\\d{3})[-. )]*)?((\\d{3})[-. ]*(\\d{2,4})(?:[-.x ]*(\\d+))?)\\s*$");
        Matcher matcher = pattern.matcher(phone);
        if (matcher.matches()) {
            this.phone = phone;
        } else {
            throw new Exception("Incorrect phone number");
        }
    }

    private String stringOrder;

    public String getStringOrder() {
        return stringOrder;
    }

    public void setStringOrder(String stringOrder) {
        this.stringOrder = stringOrder;
    }

    public UserOrder() {}
    public UserOrder(String phone, String address, String stringOrder) throws Exception {
        setAddress(address);
        setCreatedAt();
        //setEmail(email);
        setPhone(phone);
        setStringOrder(stringOrder);
    }
}
