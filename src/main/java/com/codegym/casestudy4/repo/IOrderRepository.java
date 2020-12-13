package com.codegym.casestudy4.repo;

import com.codegym.casestudy4.model.AppUser;
import com.codegym.casestudy4.model.Ordered;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends CrudRepository<Ordered, Long> {
    Iterable<Ordered> findAllByAppUser(AppUser appUser);
}
