package com.netcracker.app.domain.shop.entities;

import javax.persistence.Entity;

@Entity
public class Tech extends Devices {
    public Tech() {super();}

    public Tech(String name, double price, String description, String shortDescription, String specifications, String imgUrl) {
        super(name, price, description, shortDescription, specifications, imgUrl);
    }
}
