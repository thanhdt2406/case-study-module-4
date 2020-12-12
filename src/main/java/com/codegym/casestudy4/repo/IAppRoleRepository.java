package com.codegym.casestudy4.repo;

import com.codegym.casestudy4.model.AppRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAppRoleRepository extends CrudRepository<AppRole, Long> {
    Optional<AppRole> findByName(String name);
}
