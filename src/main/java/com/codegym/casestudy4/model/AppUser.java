package com.codegym.casestudy4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appUserId;

    @Column(unique = true)
    @Min(6)
    private String username;

    @Min(6)
    private String password;

    @Min(1)
    private String name;

    @NotNull
    private String phoneNumber;

    @Email
    private String email;

    @NotNull
    private String address;

    @Column(columnDefinition = "bit default true")
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private AppRole appRole;


    public AppUser(@Min(6) String username, @Min(6) String password, @Min(1) String name, @NotNull String phoneNumber, @Email String email, @NotNull String address, AppRole appRole) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.appRole = appRole;
    }

    public AppUser(Long appUserId, @Min(6) String username, @Min(6) String password, @Min(1) String name, @NotNull String phoneNumber, @Email String email, @NotNull String address, AppRole appRole) {
        this.appUserId = appUserId;
        this.username = username;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.appRole = appRole;
    }

    public AppUser(@Min(6) String username, @Min(6) String password, @Min(1) String name, @NotNull String phoneNumber, @Email String email, @NotNull String address, boolean status, AppRole appRole) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.status = status;
        this.appRole = appRole;
    }
}
