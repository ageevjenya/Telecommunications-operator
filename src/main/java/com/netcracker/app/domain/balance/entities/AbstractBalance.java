package com.netcracker.app.domain.balance.entities;
import com.netcracker.app.domain.users.entities.User;
import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractBalance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double money;
    private String number;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public AbstractBalance(User user,double money,String number) {
        this.money = money;
        this.number = number;
        this.user = user;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public AbstractBalance() {

    }

    @OneToOne(optional = false, mappedBy = "balance")
    private User user;
}