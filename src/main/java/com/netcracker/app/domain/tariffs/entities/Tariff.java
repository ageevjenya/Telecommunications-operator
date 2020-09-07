package com.netcracker.app.domain.tariffs.entities;

import com.netcracker.app.domain.users.entities.User;

import javax.persistence.*;
import java.util.Set;

@MappedSuperclass
public abstract class Tariff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private double priceOfMonth;
    private double gbInternet;
//    @OneToMany//(mappedBy="user") с этим не работает
//    private Set<User> users;

    public void setId(Long id) {
        this.id = id;
    }

    public double getGbInternet() {
        return gbInternet;
    }

    public void setGbInternet(double gbInternet) {
        this.gbInternet = gbInternet;
    }
/*
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }*/

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

    public Long getId() {
        return id;
    }

    public Tariff() {}
    protected Tariff(double priceOfMonth, String name, String description, double gbInternet) {
        this.priceOfMonth = priceOfMonth;
        this.name = name;
        this.description = description;
        this.gbInternet = gbInternet;
    }

}
