package com.codegym.casestudy4.repo;

import com.codegym.casestudy4.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IProductRepository extends PagingAndSortingRepository<Product,Long> {
    Iterable<Product> findTop5ByOrderByRatingDesc();
}
