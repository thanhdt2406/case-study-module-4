package com.codegym.casestudy4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @NotNull
    private String name;

    @Min(0)
    private long price;

    @Min(0)
    private int quantity;

    private String image;

    @Column(columnDefinition = "longtext")
    private String description;

    private Date createDate;

    @Column(columnDefinition = "bigint default 0")
    private long views;

    @Column(columnDefinition = "double default 0")
    private double rating;

    @Column(columnDefinition = "bit default true")
    private boolean status;

    @ManyToOne
    @JoinColumn(name="shop_id")
    private Shop shop;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    @Transient
    private MultipartFile productImage;

    public Product(@NotNull String name, @Min(0) long price, @Min(0) int quantity, String image, String description, Date createDate, long views, double rating, boolean status, Shop shop, Category category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.description = description;
        this.createDate = createDate;
        this.views = views;
        this.rating = rating;
        this.status = status;
        this.shop = shop;
        this.category = category;
    }
}
