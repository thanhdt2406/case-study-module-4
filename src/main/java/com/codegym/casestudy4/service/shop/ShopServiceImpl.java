package com.codegym.casestudy4.service.shop;

import com.codegym.casestudy4.model.Financial;
import com.codegym.casestudy4.model.Shop;
import com.codegym.casestudy4.repo.IShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ShopServiceImpl implements IShopService{
    @Autowired
    IShopRepository iShopRepository;
    @Override
    public Iterable<Shop> findAll() {
        return iShopRepository.findAll();
    }

    @Override
    public Optional<Shop> findById(Long id) {
        return iShopRepository.findById(id);
    }

    @Override
    public Shop save(Shop shop) {
        return iShopRepository.save(shop);
    }

    @Override
    public void delete(Long id) {
        iShopRepository.deleteById(id);
    }

    @Override
    public Shop findByUserID(Long userId) {
        Shop shop = iShopRepository.findByAppUser_AppUserId(userId);
        return shop;
    }

    @Override
    public void changeShopStatus(Long id) {
        iShopRepository.changeShopStatus(id);
    }

    @Override
    public Page<Shop> findShopAvailable(Pageable pageable, boolean isAvailable) {
        return iShopRepository.findShopAvailable(pageable,isAvailable);
    }

    @Override
    public Iterable<Financial> getFinancialPerMonthByShopId(Long id) {
        return iShopRepository.getFinancialPerMonthByShopId(id);
    }

}
