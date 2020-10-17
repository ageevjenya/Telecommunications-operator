package com.netcracker.app.domain.shop.entities;

import com.netcracker.app.domain.users.entities.User;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Cart {
    @Id
    @GeneratedValue
    private long id;

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToOne(optional = true)
    private User user;

    public void setFullPrice() {
        fullPrice = 0;
        if (productTechInfos != null || productModemInfos != null) {
            if (productTechInfos != null) {
                productTechInfos.forEach(productInfo -> fullPrice += productInfo.getPrice());
            }
            if (productModemInfos != null) {
                productModemInfos.forEach(productInfo -> fullPrice += productInfo.getPrice());
            }
        }
    }

    public void setCounts() {
        if (productTechInfos == null && productModemInfos == null) {
            counts = 0;
        } else {
            if (productTechInfos != null && productModemInfos != null) {
                counts = productModemInfos.stream().filter(e -> e.getAmount() != 0).toArray().length +
                productTechInfos.stream().filter(e -> e.getAmount() != 0).toArray().length;//productModemInfos.size() + productTechInfos.size();
            } else if (productModemInfos != null) {
                counts = productModemInfos.stream().filter(e -> e.getAmount() != 0).toArray().length;
            } else {
                counts = productTechInfos.stream().filter(e -> e.getAmount() != 0).toArray().length;
            }
        }
    }

    private double fullPrice;
    private int counts;

    public double getFullPrice() {
        return fullPrice;
    }

    @OneToMany
    private Set<ProductTechInfo> productTechInfos;

    public Set<ProductModemInfo> getProductModemInfos() {
        return productModemInfos;
    }

    public void setProductTechInfos(ProductTechInfo productTechInfo) {
        this.productTechInfos.add(productTechInfo);
    }

    public void setProductModemInfos(ProductModemInfo productModemInfo) {
        this.productModemInfos.add(productModemInfo);
    }

    public Set<ProductTechInfo> getProductTechInfos() {
        return productTechInfos;
    }

    @OneToMany
    private Set<ProductModemInfo> productModemInfos;

    public int getCounts() {
        return counts;
    }

    public Cart() {}

/*    public Cart(int counts, Set<ProductTechInfo> productTechInfos, Set<ProductModemInfo> productModemInfos) throws Exception {
        this.counts = counts;
        this.productInfos = productInfos;
        if (counts != productInfos.size()) {
            throw new Exception("Wrong counts of products!");
        }
        fullPrice = 0;
        productInfos.forEach(productInfo -> fullPrice += productInfo.getPrice());
    }*/
}
