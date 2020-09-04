package com.netcracker.app.domain.users;

import javax.persistence.*;

@Entity
@Table(name = "UserUsed")
public class UserUsedTariff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long idUser;
    private float usedInternet;
    private float usedMinutes;
    private float usedSms;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
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
