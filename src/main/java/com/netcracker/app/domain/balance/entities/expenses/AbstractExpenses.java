package com.netcracker.app.domain.balance.entities.expenses;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.netcracker.app.domain.tariffs.entities.TariffHome;
import com.netcracker.app.domain.users.entities.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractExpenses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Calendar activationDate;
    private double price;
    private String description;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    public AbstractExpenses() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getActivationDate() {
        return activationDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setActivationDate(Calendar activationDate) {
        this.activationDate = activationDate;
    }

    public AbstractExpenses(Calendar activationDate, double price, String description, User user) {
        this.activationDate = activationDate;
        this.price = price;
        this.description = description;
        this.user = user;
    }
}

