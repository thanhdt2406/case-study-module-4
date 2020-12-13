package com.codegym.casestudy4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ratingId;

    @Column(columnDefinition = "longtext")
    private String comment;

    @Min(0)
    @Max(5)
    private double stars;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name="app_user_id")
    private AppUser appUser;

    public Rating(String comment, @Min(1) @Max(5) int stars, Product product, AppUser appUser) {
        this.comment = comment;
        this.stars = stars;
        this.product = product;
        this.appUser = appUser;
    }
}
