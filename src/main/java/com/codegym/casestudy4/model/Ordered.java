package com.codegym.casestudy4.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Ordered {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private Date orderDate;

    @ManyToOne
    @JoinColumn(name = "app_user_id")
    private AppUser appUser;

    public Ordered() {

    }

    public Ordered(Date orderDate, AppUser appUser) {
        this.orderDate = orderDate;
        this.appUser = appUser;
    }

    public Ordered(Long orderId, Date orderDate, AppUser appUser) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.appUser = appUser;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
