package com.codegym.casestudy4.service.order;

import com.codegym.casestudy4.model.AppUser;
import com.codegym.casestudy4.model.Ordered;
import com.codegym.casestudy4.repo.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements IOrderedService{
    @Autowired
    private IOrderRepository iOrderRepository;

    @Override
    public Iterable<Ordered> findAll() {
        return null;
    }

    @Override
    public Optional<Ordered> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Ordered save(Ordered ordered) {
        return iOrderRepository.save(ordered);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Iterable<Ordered> findAllByAppUser(AppUser appUser) {
        return iOrderRepository.findAllByAppUser(appUser);
    }
}
