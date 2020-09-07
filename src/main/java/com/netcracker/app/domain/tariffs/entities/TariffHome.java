package com.netcracker.app.domain.tariffs.entities;

import com.netcracker.app.domain.users.entities.User;

import javax.persistence.*;
import java.util.Set;


@Entity
//@Table(name = "TariffHome")
public class TariffHome extends Tariff {

    @OneToMany/*(mappedBy="user")*/
    private Set<User> users;

    public TariffHome() {
    }

    public TariffHome(String name, double priceOfMonth, double gbInternet, String description) {
        super(priceOfMonth, name, description, gbInternet);
    }

    //@Override
    public Set<User> getUsers() {
        return users;
    }

   // @Override
    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
