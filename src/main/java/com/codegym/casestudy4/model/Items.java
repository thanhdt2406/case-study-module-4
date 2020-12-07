package com.codegym.casestudy4.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table
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

    public Items() {

    }

    public Items(Cart cart, Product product, @NotNull @Min(0) int quantity) {
        this.cart = cart;
        this.product = product;
        this.quantity = quantity;
    }

    public Items(Long itemId, Cart cart, Product product, @NotNull @Min(0) int quantity) {
        this.itemId = itemId;
        this.cart = cart;
        this.product = product;
        this.quantity = quantity;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Items{" +
                "itemId=" + itemId +
                ", cart=" + cart +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
