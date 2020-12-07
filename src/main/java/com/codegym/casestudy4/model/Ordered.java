package com.codegym.casestudy4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ordered {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private Date orderDate;

    @ManyToOne
    @JoinColumn(name = "app_user_id")
    private AppUser appUser;

    public Ordered(Date orderDate, AppUser appUser) {
        this.orderDate = orderDate;
        this.appUser = appUser;
    }
}
