package com.codegym.casestudy4.service.appuser;

import com.codegym.casestudy4.model.AppUser;
import com.codegym.casestudy4.service.IService;

public interface IAppUserService extends IService<AppUser> {
    AppUser getUserByUsername(String username);
}
