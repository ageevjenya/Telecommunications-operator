package com.netcracker.app.domain.balance.entities.payment;

import javax.persistence.Entity;

@Entity
public class PaymentImpl extends AbstractPayment{
    public PaymentImpl() { super(); }
    public PaymentImpl(String cardName,String cardSurname,Integer cardNumber) {
        super(cardName,cardSurname,cardNumber);
    }
}
