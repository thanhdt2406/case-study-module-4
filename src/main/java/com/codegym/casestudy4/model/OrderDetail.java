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

    public OrderDetail(@NotNull @Min(0) int quantity, Ordered ordered, Product product) {
        this.quantity = quantity;
        this.ordered = ordered;
        this.product = product;
    }
}
