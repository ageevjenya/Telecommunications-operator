package com.netcracker.app.domain.tariffs.entities;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class Internet extends TariffOldMustDelete {

    public Internet() {
    }

    public Internet(String name, double priceOfMonth, double gbInternet, String description) {
        super(priceOfMonth, name, description, gbInternet);
    }
}
