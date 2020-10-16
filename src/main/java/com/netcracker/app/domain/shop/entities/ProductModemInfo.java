package com.netcracker.app.domain.shop.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ProductModemInfo {
    @Id
    @GeneratedValue
    private int id;
    protected int amount;
    protected double price;

    public void setPrice() {
        if (device != null) {
            price = device.getPrice() * amount;
        } else {
            price = 0;
        }
    }

    public double getPrice() {
        if (device != null) {
            return price;/* = device.getPrice() * amount;*/
        }
        return 0;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Modem getDevice() throws Exception {
        if (device != null) {
            return device;
        }
        throw new Exception("No device");
    }

    public void setDevice(Modem device) {
        this.device = device;
        amount = 1;
        price = device.getPrice();
    }

    public int getAmount(){
        return amount;
    }

    public void setAmount(int amount) throws Exception {
        if (amount == 0) {
            this.amount = 0;
        } else if (amount == 1) {
            this.amount++;
        } else if (amount == -1) {
            this.amount--;
        }
        if (amount < -1 || amount > 1) {
            throw new Exception("Wrong amount");
        }
        price = device.getPrice() * this.amount;
    }

    @ManyToOne(optional = false)
    private Cart cart;

    @ManyToOne(optional = false)
    private Modem device;

    public ProductModemInfo(Modem device, int amount, Cart cart) throws Exception {
        if (amount <= 0) {
            throw new Exception("Wrong amount of devices");
        }
        this.cart = cart;
        this.amount = amount;
        this.device = device;
        price = device.getPrice() * amount;
    }

    public ProductModemInfo() { super(); }
}
