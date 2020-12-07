package com.codegym.casestudy4.model;

import javax.persistence.*;

@Entity
@Table
public class Cart {
    @Id
    private Long cartId;

    @OneToOne
    @JoinColumn(name="app_user_id")
    private AppUser appUser;

    public Cart() {

    }

    public Cart(AppUser appUser) {
        this.appUser = appUser;
    }

    public Cart(Long cartId, AppUser appUser) {
        this.cartId = cartId;
        this.appUser = appUser;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
