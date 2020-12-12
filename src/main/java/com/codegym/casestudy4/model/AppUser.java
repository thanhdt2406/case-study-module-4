package com.codegym.casestudy4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
    @Size(min=6)
    private String username;

    @Size(min=6)
    private String password;

    @Size(min=1)
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


    public AppUser(@Size(min=6) String username, @Size(min=6) String password, @Size(min=1) String name, @NotNull String phoneNumber, @Email String email, @NotNull String address, AppRole appRole) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.appRole = appRole;
    }

    public AppUser(Long appUserId, @Size(min=6) String username, @Size(min=6) String password, @Size(min=1) String name, @NotNull String phoneNumber, @Email String email, @NotNull String address, AppRole appRole) {
        this.appUserId = appUserId;
        this.username = username;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.appRole = appRole;
    }

    public AppUser(@Size(min=6) String username, @Size(min=6) String password, @Size(min=1) String name, @NotNull String phoneNumber, @Email String email, @NotNull String address, boolean status, AppRole appRole) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.status = status;
        this.appRole = appRole;
    }

    public AppUser(@Size(min=6) String username, @Size(min=6) String password, @Size(min=1) String name, @NotNull String phoneNumber, @Email String email, @NotNull String address) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }
}
