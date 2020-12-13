package com.codegym.casestudy4.repo;

import com.codegym.casestudy4.model.AppUser;
import com.codegym.casestudy4.model.Rating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRatingRepository extends CrudRepository<Rating,Long> {
    Rating findByProduct_ProductIdAndAppUser(Long id, AppUser appUser);
}
