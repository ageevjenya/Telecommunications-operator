package com.netcracker.app.domain.tariffs.entities;

import com.netcracker.app.domain.users.entities.User;

import javax.persistence.*;
import java.util.Set;

@Entity
//@Table(name = "TariffMobile")
public class TariffMobile extends Tariff {

    private double gbInternet;
    private int minutes;

    private int sms;
    @OneToMany//(mappedBy="user")
    private Set<User> users;

    public TariffMobile(int minutes, int sms, double priceOfMonth, String name, String description, double gbInternet) {
        super(priceOfMonth, name, description);
        this.gbInternet = gbInternet;
        this.minutes = minutes;
        this.sms = sms;
    }

    //@Override
    public Set<User> getUsers() {
        return users;
    }

    //@Override
    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSms() {
        return sms;
    }

    public void setSms(int sms) {
        this.sms = sms;
    }

    public double getGbInternet() {
        return gbInternet;
    }

    public void setGbInternet(double gbInternet) {
        this.gbInternet = gbInternet;
    }

    public TariffMobile() {}

    public static String[] getFieldsNames() {
        String[] names = {"name",  "description", "priceOfMonth","gbInternet" , "minutes", "sms"  };
        return names;
    }
}