package com.codegym.casestudy4.repo;

import com.codegym.casestudy4.model.Items;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.nio.file.LinkOption;
@Repository
public interface ItemsRepository extends CrudRepository<Items, Long> {
}
