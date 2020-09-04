package com.netcracker.app.domain.tariffs.entities;

import javax.persistence.*;

@Entity
public class Mobile extends TariffOldMustDelete {

    private int minutes;

    private int sms;

    public Mobile(int minutes, int sms, double priceOfMonth, String name, String description, double gbInternet) {
        super(priceOfMonth, name, description, gbInternet);
        this.minutes = minutes;
        this.sms = sms;
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

    public Mobile() {}

    public static String[] getFieldsNames() {
        String[] names = {"name", "minutes", "sms", "priceOfMonth", "description", "gbInternet"};
        return names;
    }
}