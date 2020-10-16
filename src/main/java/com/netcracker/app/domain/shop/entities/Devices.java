package com.netcracker.app.domain.shop.entities;

import javax.persistence.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

@MappedSuperclass
public abstract class Devices {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private double price;
    private String description;
    private String shortDescription;
    private String specifications;
    private String imgUrl;

    public Integer getId() {
        return id;
    }

    public Devices(String name, double price, String description, String shortDescription, String specifications, String imgUrl) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.shortDescription = shortDescription;
        this.specifications = specifications;
        setImgUrl(imgUrl);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        try {
            URL url = new URL(imgUrl);
            this.imgUrl = imgUrl;
        }
        catch(MalformedURLException e) {
            System.out.println("Incorrect URL");
        }
    }

    public Devices() {}
}
