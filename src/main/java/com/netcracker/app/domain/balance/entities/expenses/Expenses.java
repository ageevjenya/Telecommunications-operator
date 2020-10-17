package com.netcracker.app.domain.balance.entities.expenses;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Expenses extends AbstractExpenses {
    public Expenses(double priceOfMonthMobile, double priceOfMonthHomeInternet, LocalDate mobileActivationDate, LocalDate homeInternetActivationDate) {
        super(priceOfMonthMobile, priceOfMonthHomeInternet, mobileActivationDate, homeInternetActivationDate);
    }

    public Expenses() { super(); }
}