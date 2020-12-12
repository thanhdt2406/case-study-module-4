package com.codegym.casestudy4.service.product;

import com.codegym.casestudy4.model.AppUser;
import com.codegym.casestudy4.model.Cart;
import com.codegym.casestudy4.model.Category;
import com.codegym.casestudy4.model.Product;
import com.codegym.casestudy4.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProductService extends IGeneralService<Product> {
    Page<Product> findAll(Pageable pageable);

    Page<Product> findAllByNameContaining(String name, Pageable pageable);

    Iterable<Product> findAllProductAvailable(Long shopId);

    Page<Product> findAllByName(String name, Pageable pageable);

    Iterable<Product> findAllByCategory(Category category);

    Iterable<Product> findAllByPriceBetween(Long min, Long max);
    Iterable<Product> findAllByPriceDesc();

    Iterable<Product> findAllByPriceAsc();

    Iterable<Product> findAllProductOrderByStarsDesc();
//    DUNG
    List<Product> findAllProductByCart(Cart cart);

    void addProductToCart(Long id);



}
