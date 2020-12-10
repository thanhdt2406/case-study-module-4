package com.codegym.casestudy4.service.product;

import com.codegym.casestudy4.model.Product;
import com.codegym.casestudy4.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService extends IGeneralService<Product> {
    Page<Product> findAll(Pageable pageable);

    Page<Product> findAllByNameContaining(String name, Pageable pageable);
}
