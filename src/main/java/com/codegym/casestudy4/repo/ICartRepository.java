package com.codegym.casestudy4.repo;

import com.codegym.casestudy4.model.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICartRepository extends CrudRepository<Cart, Long> {
    Cart findByAppUser_AppUserId(Long id);
}
