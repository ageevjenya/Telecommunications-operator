package com.netcracker.app.domain.balance.entities.payment;

public interface Payment {
    public Integer getId();
    public void setId(Integer id);
    public String getCardName();
    public void setCardName(String name);
    public String getCardSurname();
    public void setCardSurname(String surname);
    public Integer getCardNumber();
    public void setCardNumber(Integer number);
}
