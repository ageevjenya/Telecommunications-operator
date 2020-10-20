package com.netcracker.app.domain.users.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.netcracker.app.domain.users.entities.User;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Entity
@Table(name = "UserUsed")
public class UserUsedTariffMobile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonIgnore
    @OneToOne(optional = false, mappedBy = "userUsedTariffMobile")
    private User user;

    private double usedInternet;
    private int usedMinutes;
    private int usedSms;

    public UserUsedTariffMobile() {
    }

    public UserUsedTariffMobile(User user, double usedInternet, int usedMinutes, int usedSms) {
        this.user = user;
        this.usedInternet = usedInternet;
        this.usedMinutes = usedMinutes;
        this.usedSms = usedSms;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getUsedInternet() {
        return usedInternet;
    }

    public void setUsedInternet(double usedInternet) {
        this.usedInternet = usedInternet;
    }

    public int getUsedMinutes() {
        return usedMinutes;
    }

    public void setUsedMinutes(int usedMinutes) {
        this.usedMinutes = usedMinutes;
    }

    public int getUsedSms() {
        return usedSms;
    }

    public void setUsedSms(int usedSms) {
        this.usedSms = usedSms;
    }
}
