package com.codegym.casestudy4.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @NotNull
    private String name;

    public Category() {

    }

    public Category(@NotNull String name) {
        this.name = name;
    }

    public Category(Long categoryId, @NotNull String name) {
        this.categoryId = categoryId;
        this.name = name;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
