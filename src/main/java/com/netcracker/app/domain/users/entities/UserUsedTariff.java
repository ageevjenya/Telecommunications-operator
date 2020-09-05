package com.netcracker.app.domain.users.entities;

import com.netcracker.app.domain.users.entities.User;

import javax.persistence.*;

@Entity
@Table(name = "UserUsed")
public class UserUsedTariff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    private float usedInternet;
    private float usedMinutes;
    private float usedSms;


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

    public float getUsedInternet() {
        return usedInternet;
    }

    public void setUsedInternet(float usedInternet) {
        this.usedInternet = usedInternet;
    }

    public float getUsedMinutes() {
        return usedMinutes;
    }

    public void setUsedMinutes(float usedMinutes) {
        this.usedMinutes = usedMinutes;
    }

    public float getUsedSms() {
        return usedSms;
    }

    public void setUsedSms(float usedSms) {
        this.usedSms = usedSms;
    }
}
