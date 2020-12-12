package com.codegym.casestudy4.service.approle;

import com.codegym.casestudy4.model.AppRole;
import com.codegym.casestudy4.service.IGeneralService;

public interface IAppRoleService extends IGeneralService<AppRole> {
    AppRole findByName(String name);
}
