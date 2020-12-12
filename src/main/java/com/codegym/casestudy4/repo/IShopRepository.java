package com.codegym.casestudy4.repo;

import com.codegym.casestudy4.model.Shop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@EnableJpaRepositories
public interface IShopRepository extends JpaRepository<Shop, Long> {
    Shop findByAppUser_AppUserId(Long userId);

    @Modifying
    @Transactional
    @Query(value = "update case4.shop set status = !status where shop_id = ?1", nativeQuery = true)
    void changeShopStatus(Long id);

    @Transactional
    @Query(value = "select * from shop where status=?1", nativeQuery = true)
    Page<Shop> findShopAvailable(Pageable pageable, boolean isAvailable);
}
