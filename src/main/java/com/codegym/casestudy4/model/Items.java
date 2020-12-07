package com.codegym.casestudy4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Items {
    @Id
    private Long itemId;

    @ManyToOne
    @JoinColumn(name="cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    @NotNull
    @Min(0)
    private int quantity;

    public Items(Cart cart, Product product, @NotNull @Min(0) int quantity) {
        this.cart = cart;
        this.product = product;
        this.quantity = quantity;
    }
}
