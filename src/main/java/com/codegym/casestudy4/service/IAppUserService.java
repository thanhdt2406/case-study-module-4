package com.codegym.casestudy4.service;

import com.codegym.casestudy4.model.AppUser;

public interface IAppUserService {
    AppUser getUserByUsername(String username);
}
