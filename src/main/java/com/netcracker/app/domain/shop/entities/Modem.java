package com.netcracker.app.domain.shop.entities;

import javax.persistence.Entity;

@Entity
public class Modem extends Devices {
    public Modem() {super();}

    public Modem(String name, double price, String description, String shortDescription, String specifications, String imgUrl) {
        super(name, price, description, shortDescription, specifications, imgUrl);
    }
}
