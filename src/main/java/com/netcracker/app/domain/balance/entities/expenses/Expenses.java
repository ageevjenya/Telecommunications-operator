package com.netcracker.app.domain.balance.entities.expenses;

import com.netcracker.app.domain.balance.entities.Balance;
import com.netcracker.app.domain.users.entities.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

@Entity
public class Expenses extends AbstractExpenses {


    public Expenses() {

    }

    public Expenses(Calendar activationDate, double price, String description, User user) {
        super(activationDate, price, description, user);
    }
}
