package com.netcracker.app.domain.balance.entities.payment;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractPayment implements Payment{
    @Id
    @GeneratedValue
    private Integer id;

    private String cardName;
    private String cardSurname;
    private Integer cardNumber;
    public AbstractPayment() {

    }

    public AbstractPayment(String cardName, String cardSurname,Integer cardNumber) {
        this.cardName = cardName;
        this.cardSurname = cardSurname;
        this.cardNumber = cardNumber;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardSurname() {
        return cardSurname;
    }

    public void setCardSurname(String cardSurname) {
        this.cardSurname = cardSurname;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }
}
