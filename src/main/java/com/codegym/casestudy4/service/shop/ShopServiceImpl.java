package com.codegym.casestudy4.service.shop;

import com.codegym.casestudy4.model.Shop;
import com.codegym.casestudy4.repo.IShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        System.out.println(shop.getName());
        return shop;
    }
}
