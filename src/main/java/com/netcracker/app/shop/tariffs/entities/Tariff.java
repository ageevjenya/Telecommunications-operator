package com.netcracker.app.shop.tariffs.entities;

import javax.persistence.*;

@MappedSuperclass
public abstract class Tariff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private double priceOfMonth;

    private String name;

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPriceOfMonth() {
        if (priceOfMonth == 0) {
            throw new NullPointerException();
        }
        return priceOfMonth;
    }

    public void setPriceOfMonth(double priceOfMonth) {
        this.priceOfMonth = priceOfMonth;
    }

    public String getName() {
        if (name == null) {
            throw new NullPointerException();
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public Tariff() {}
    protected Tariff(double priceOfMonth, String name, String description) {
        this.priceOfMonth = priceOfMonth;
        this.name = name;
        this.description = description;
    }
}
