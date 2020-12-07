package com.codegym.casestudy4.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ratingId;

    @Column(columnDefinition = "longtext")
    private String comment;

    @Min(1)
    @Max(5)
    private int stars;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name="app_user_id")
    private AppUser appUser;

    public Rating() {

    }

    public Rating(String comment, @Min(1) @Max(5) int stars, Product product, AppUser appUser) {
        this.comment = comment;
        this.stars = stars;
        this.product = product;
        this.appUser = appUser;
    }

    public Rating(Long ratingId, String comment, @Min(1) @Max(5) int stars, Product product, AppUser appUser) {
        this.ratingId = ratingId;
        this.comment = comment;
        this.stars = stars;
        this.product = product;
        this.appUser = appUser;
    }

    public Long getRatingId() {
        return ratingId;
    }

    public void setRatingId(Long ratingId) {
        this.ratingId = ratingId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

}
