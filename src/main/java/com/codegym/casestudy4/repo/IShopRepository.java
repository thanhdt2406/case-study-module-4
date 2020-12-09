package com.codegym.casestudy4.repo;

import com.codegym.casestudy4.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IShopRepository extends JpaRepository<Shop, Long> {
}
