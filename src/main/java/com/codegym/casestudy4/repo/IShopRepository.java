package com.codegym.casestudy4.repo;

import com.codegym.casestudy4.model.Product;
import com.codegym.casestudy4.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IShopRepository extends JpaRepository<Shop, Long> {
    Shop findByAppUser_AppUserId(Long userId);
}
