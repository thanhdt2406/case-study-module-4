package com.codegym.casestudy4.service.appuser;

import com.codegym.casestudy4.model.AppUser;
import com.codegym.casestudy4.service.IGeneralService;

public interface IAppUserService extends IGeneralService<AppUser> {
    AppUser getUserByUsername(String username);

    AppUser getUserLogin();
}
