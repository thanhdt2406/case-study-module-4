package com.codegym.casestudy4.repo;

import com.codegym.casestudy4.model.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppUserRepository extends CrudRepository<AppUser,Long> {
    AppUser findByUsername(String username);
}
