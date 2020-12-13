package com.codegym.casestudy4.service.rating;

import com.codegym.casestudy4.model.AppUser;
import com.codegym.casestudy4.model.Rating;
import com.codegym.casestudy4.service.IGeneralService;

public interface IRatingService extends IGeneralService<Rating> {
    Rating findByProduct_ProductIdAndAppUser(Long id, AppUser appUser);

    Double findAvgRatingByProductId(Long id);

    Iterable<Rating> findAllByProduct_ProductId(Long id);
}
