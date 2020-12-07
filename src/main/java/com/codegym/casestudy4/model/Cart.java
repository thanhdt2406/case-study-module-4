package com.codegym.casestudy4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Id
    private Long cartId;

    @OneToOne
    @JoinColumn(name="app_user_id")
    private AppUser appUser;

    public Cart(AppUser appUser) {
        this.appUser = appUser;
    }
}
