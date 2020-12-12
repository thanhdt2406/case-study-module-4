package com.codegym.casestudy4.repo;

import com.codegym.casestudy4.model.Category;
import com.codegym.casestudy4.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Repository
public interface IProductRepository extends PagingAndSortingRepository<Product,Long> {
    Iterable<Product> findTop5ByOrderByRatingDesc();

    @Override
    Page<Product> findAll(Pageable pageable);

    Page<Product> findAllByNameContaining(String name, Pageable pageable);

    Iterable<Product> findAllByShop_ShopIdAndStatusTrue(Long ShopId);

    Page<Product> findAllByName(String name, Pageable pageable);

    Iterable<Product> findAllByCategory(Category category);

    Iterable<Product> findAllByOrderByPriceDesc();

    Iterable<Product> findAllByOrderByPriceAsc();

    @Transactional
    @Query(value = "select product.*\n" +
            "from product\n" +
            "         join rating r on product.product_id = r.product_id\n" +
            "group by (product_id)\n" +
            "order by sum(stars) desc",nativeQuery = true)
    Iterable<Product> findAllProductOrderByStarsDesc();
}
