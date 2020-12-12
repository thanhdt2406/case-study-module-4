package com.codegym.casestudy4.service.approle;

import com.codegym.casestudy4.model.AppRole;
import com.codegym.casestudy4.repo.IAppRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppRoleServiceImpl implements IAppRoleService{
    @Autowired
    private IAppRoleRepository appRoleRepository;

    @Override
    public Iterable<AppRole> findAll() {
        return null;
    }

    @Override
    public Optional<AppRole> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public AppRole save(AppRole appRole) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public AppRole findByName(String name) {
        return appRoleRepository.findByName(name).get();
    }
}
