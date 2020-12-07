package com.codegym.casestudy4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shopId;

    @Min(1)
    private String name;

    private String address;

    @Column(columnDefinition = "longtext")
    private String description;

    @OneToOne
    @JoinColumn(name="app_user_id")
    private AppUser appUser;

    public Shop(@Min(1) String name, String address, String description, AppUser appUser) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.appUser = appUser;
    }
}
