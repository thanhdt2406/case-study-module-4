package com.codegym.casestudy4.repo;

import com.codegym.casestudy4.model.AppUser;
import com.codegym.casestudy4.model.Rating;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IRatingRepository extends CrudRepository<Rating,Long> {
    Rating findByProduct_ProductIdAndAppUser(Long id, AppUser appUser);

    @Transactional
    @Query(value = "select avg(stars) from rating where product_id = ?1",nativeQuery = true)
    Double findAvgRatingByProductId(Long id);

    Iterable<Rating> findAllByProduct_ProductId(Long id);
}
