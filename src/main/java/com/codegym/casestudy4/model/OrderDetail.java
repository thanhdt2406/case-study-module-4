package com.codegym.casestudy4.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderDetailId;

    @NotNull
    @Min(0)
    private int quantity;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Ordered ordered;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    public OrderDetail() {

    }

    public OrderDetail(@NotNull @Min(0) int quantity, Ordered ordered, Product product) {
        this.quantity = quantity;
        this.ordered = ordered;
        this.product = product;
    }

    public OrderDetail(Long orderDetailId, @NotNull @Min(0) int quantity, Ordered ordered, Product product) {
        this.orderDetailId = orderDetailId;
        this.quantity = quantity;
        this.ordered = ordered;
        this.product = product;
    }

    public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Ordered getOrder() {
        return ordered;
    }

    public void setOrder(Ordered ordered) {
        this.ordered = ordered;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
