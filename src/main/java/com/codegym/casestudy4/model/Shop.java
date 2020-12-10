package com.codegym.casestudy4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shopId;

    @Size(min=1)
    private String name;

    private String address;

    @Column(columnDefinition = "bit default 1")
    private boolean status;

    @Column(columnDefinition = "longtext")
    private String description;

    @OneToOne
    @JoinColumn(name="app_user_id")
    private AppUser appUser;

    public Shop(@Size(min=1) String name, String address, String description, AppUser appUser) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.appUser = appUser;
    }
}
