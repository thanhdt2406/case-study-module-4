package com.codegym.casestudy4.service.shop;

import com.codegym.casestudy4.model.Shop;
import com.codegym.casestudy4.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IShopService extends IGeneralService<Shop> {
    Shop findByUserID(Long userId);

    void changeShopStatus(Long id);

    Page<Shop> findShopAvailable(Pageable pageable,boolean isAvailable);
}
