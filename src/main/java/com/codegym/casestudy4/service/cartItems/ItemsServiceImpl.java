package com.codegym.casestudy4.service.cartItems;

import com.codegym.casestudy4.model.Cart;
import com.codegym.casestudy4.model.Items;
import com.codegym.casestudy4.model.Product;
import com.codegym.casestudy4.repo.ItemsRepository;
import com.codegym.casestudy4.service.cart.ICartService;
import com.codegym.casestudy4.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private IProductService productService;
    @Autowired
    private ItemsRepository itemsRepository;

    @Override
    public Iterable<Items> findAll() {
        return itemsRepository.findAll();
    }

    @Override
    public Optional<Items> findById(Long id) {
        return itemsRepository.findById(id);
    }

    @Override
    public Items save(Items items) {
        return itemsRepository.save(items);
    }

    @Override
    public void delete(Long id) {
        itemsRepository.deleteById(id);
    }

}
