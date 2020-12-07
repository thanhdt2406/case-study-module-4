package com.codegym.casestudy4.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table
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

    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public AppUser() {

    }

    public AppUser(@Min(6) String username, @Min(6) String password, @Min(1) String name, @NotNull String phoneNumber, @Email String email, @NotNull String address, Role role) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.role = role;
    }

    public AppUser(Long appUserId, @Min(6) String username, @Min(6) String password, @Min(1) String name, @NotNull String phoneNumber, @Email String email, @NotNull String address, Role role) {
        this.appUserId = appUserId;
        this.username = username;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.role = role;
    }

    public AppUser(Long appUserId, @Min(6) String username, @Min(6) String password, @Min(1) String name, @NotNull String phoneNumber, @Email String email, @NotNull String address, boolean status, Role role) {
        this.appUserId = appUserId;
        this.username = username;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.status = status;
        this.role = role;
    }

    public AppUser(@Min(6) String username, @Min(6) String password, @Min(1) String name, @NotNull String phoneNumber, @Email String email, @NotNull String address, boolean status, Role role) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.status = status;
        this.role = role;
    }

    public Long getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(Long appUserId) {
        this.appUserId = appUserId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "appUserId=" + appUserId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", role=" + role +
                '}';
    }
}
