package com.codegym.casestudy4.service.category;

import com.codegym.casestudy4.model.Category;
import com.codegym.casestudy4.service.IGeneralService;

import java.util.Optional;

public interface ICategoryService extends IGeneralService<Category> {
    Optional<Category> findCategoryByName(String name);
}
