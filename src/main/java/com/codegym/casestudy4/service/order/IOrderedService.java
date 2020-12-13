package com.codegym.casestudy4.service.order;

import com.codegym.casestudy4.model.AppUser;
import com.codegym.casestudy4.model.Ordered;
import com.codegym.casestudy4.service.IGeneralService;

public interface IOrderedService extends IGeneralService<Ordered> {
    Iterable<Ordered> findAllByAppUser(AppUser appUser);
}
