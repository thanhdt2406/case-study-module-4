package com.codegym.casestudy4.service.cart;

import com.codegym.casestudy4.model.Cart;
import com.codegym.casestudy4.repo.ICartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CartServiceImpl implements ICartService{
    @Autowired
    private ICartRepository iCartRepository;
    @Override
    public Iterable<Cart> findAll() {
        return iCartRepository.findAll();
    }

    @Override
    public Optional<Cart> findById(Long id) {
        return iCartRepository.findById(id);
    }

    @Override
    public Cart save(Cart cart) {
        return iCartRepository.save(cart);
    }

    @Override
    public void delete(Long id) {
        iCartRepository.deleteById(id);
    }

    @Override
    public Cart findByAppUser_AppUserId(Long id) {
        return iCartRepository.findByAppUser_AppUserId(id);
    }
}
