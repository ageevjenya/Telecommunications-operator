package com.netcracker.app.domain.tariffs.entities;

import javax.persistence.*;

@Entity
public class Mobile extends Tariff {

    private int minutes;

    private int sms;

    public Mobile(int minutes, int sms, double priceOfMonth, String name, String description) {
        super(priceOfMonth, name, description);
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
}