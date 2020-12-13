package com.codegym.casestudy4.service.appuser;

import com.codegym.casestudy4.model.AppUser;
import com.codegym.casestudy4.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IAppUserService extends IGeneralService<AppUser> {
    AppUser getUserByUsername(String username);

    AppUser getUserLogin();

    void changeUserStatus(Long id);

    Page<AppUser> findAppUserAvailable(Pageable pageable, String roleName, boolean isAvailable);

    void changeAppUserRole(String roleName,Long id);

}
