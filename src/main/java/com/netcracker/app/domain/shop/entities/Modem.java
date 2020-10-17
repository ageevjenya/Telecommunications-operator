package com.netcracker.app.domain.shop.entities;

import org.hibernate.annotations.Type;

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
    private Set<ProductModemInfo> productModemInfos;

    @OneToMany
    private Set<ImgModem> imgModems;

    public Set<ImgModem> getImgModems() {
        return imgModems;
    }

    public void setImgModems(Set<ImgModem> imgModems) {
        this.imgModems = imgModems;
    }

    public Modem(String name, double price, String description, String shortDescription, String specifications, String imgUrl) {
        super(name, price, description, shortDescription, specifications, imgUrl);
    }
}
