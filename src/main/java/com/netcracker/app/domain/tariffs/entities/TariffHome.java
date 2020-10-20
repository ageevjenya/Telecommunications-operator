package com.netcracker.app.domain.tariffs.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.netcracker.app.domain.users.entities.User;

import javax.persistence.*;
import java.util.Set;


@Entity
//@Table(name = "TariffHome")
public class TariffHome extends Tariff {


    private Integer speedInternet;
    @JsonIgnore
    @OneToMany//(mappedBy="user")
    private Set<User> users;

    public TariffHome() {
    }

    public TariffHome(String name, double priceOfMonth, Integer speedInternet, String description) {
        super(priceOfMonth, name, description);
        this.speedInternet = speedInternet;
    }

    //    @Override
    public Set<User> getUsers() {
        return users;
    }

    //   @Override
    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Integer getSpeedInternet() {
        return speedInternet;
    }

    public void setSpeedInternet(Integer speedInternet) {
        this.speedInternet = speedInternet;
    }
}
