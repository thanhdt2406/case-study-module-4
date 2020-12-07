package com.codegym.casestudy4.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shopId;

    @Min(1)
    private String name;
    private String address;
    @Column(columnDefinition = "longtext")
    private String description;

    @OneToOne
    @JoinColumn(name="app_user_id")
    private AppUser appUser;

    public Shop() {

    }

    public Shop(@Min(1) String name, String address, String description, AppUser appUser) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.appUser = appUser;
    }

    public Shop(Long shopId, @Min(1) String name, String address, String description, AppUser appUser) {
        this.shopId = shopId;
        this.name = name;
        this.address = address;
        this.description = description;
        this.appUser = appUser;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "shopId=" + shopId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", appUser=" + appUser +
                '}';
    }
}
