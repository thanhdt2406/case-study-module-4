package com.codegym.casestudy4.repo;

import com.codegym.casestudy4.model.Financial;
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

    @Transactional
    @Query(value = "select shop_id as shopId,sum(od.quantity * p.price) as money, month(order_date) as month from ordered join order_detail od on ordered.order_id = od.order_id join product p on p.product_id = od.product_id and shop_id = ?1 group by shop_id, month(order_date)", nativeQuery = true)
    Iterable<Financial> getFinancialPerMonthByShopId(Long id);
}
