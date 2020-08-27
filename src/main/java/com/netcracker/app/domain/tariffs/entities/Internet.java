package com.netcracker.app.domain.tariffs.entities;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class Internet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String pack;

    private String price;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Internet() {
    }



    public Internet(String pack, String price) {
        this.pack = pack;
        this.price = price;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPack() {
        return pack;
    }

    public void setPack(String pack) {
        this.pack = pack;
    }

    public String getCost() {
        return price;
    }

    public void setCost(String price) {
        this.price = price;
    }
}
