package com.netcracker.app.domain.shop.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Modem extends Devices {
    public Modem() {super();}

    public Set<ImgModem> getImgModem() {
        return imgModems;
    }

    public void setImgModem(Set<ImgModem> imgModems) {
        this.imgModems = imgModems;
    }

    @OneToMany
    private Set<ImgModem> imgModems;

    public Modem(String name, double price, String description, String shortDescription, String specifications, String imgUrl) {
        super(name, price, description, shortDescription, specifications, imgUrl);
    }
}
