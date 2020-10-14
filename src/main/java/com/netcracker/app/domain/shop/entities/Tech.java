package com.netcracker.app.domain.shop.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Tech extends Devices {
    public Tech() {super();}

    public Set<ImgTech> getImgTechs() {
        return imgTechs;
    }

    public void setImgTechs(Set<ImgTech> imgTechs) {
        this.imgTechs = imgTechs;
    }

    @OneToMany
    private Set<ImgTech> imgTechs;

    public Tech(String name, double price, String description, String shortDescription, String specifications, String imgUrl) {
        super(name, price, description, shortDescription, specifications, imgUrl);
    }
}
