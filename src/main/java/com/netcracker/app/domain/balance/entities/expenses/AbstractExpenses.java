package com.netcracker.app.domain.balance.entities.expenses;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractExpenses {
    @Id
    @GeneratedValue
    private Long id;
    private double priceOfMonthMobile;
    private double priceOfMonthHomeInternet;
    private LocalDate mobileActivationDate;
    private LocalDate homeInternetActivationDate;

    public AbstractExpenses() {
    }

    public AbstractExpenses(double priceOfMonthMobile, double priceOfMonthHomeInternet, LocalDate mobileActivationDate, LocalDate homeInternetActivationDate) {
        this.priceOfMonthMobile = priceOfMonthMobile;
        this.priceOfMonthHomeInternet = priceOfMonthHomeInternet;
        this.mobileActivationDate = mobileActivationDate;
        this.homeInternetActivationDate = homeInternetActivationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPriceOfMonthMobile() {
        return priceOfMonthMobile;
    }

    public void setPriceOfMonthMobile(double priceOfMonthMobile) {
        this.priceOfMonthMobile = priceOfMonthMobile;
    }

    public double getPriceOfMonthHomeInternet() {
        return priceOfMonthHomeInternet;
    }

    public void setPriceOfMonthHomeInternet(double priceOfMonthHomeInternet) {
        this.priceOfMonthHomeInternet = priceOfMonthHomeInternet;
    }

    public LocalDate getMobileActivationDate() {
        return mobileActivationDate;
    }

    public void setMobileActivationDate(LocalDate mobileActivationDate) {
        this.mobileActivationDate = mobileActivationDate;
    }

    public LocalDate getHomeInternetActivationDate() {
        return homeInternetActivationDate;
    }

    public void setHomeInternetActivationDate(LocalDate homeInternetActivationDate) {
        this.homeInternetActivationDate = homeInternetActivationDate;
    }
}

