package com.codegym.casestudy4.service.cartItems;

import com.codegym.casestudy4.model.Cart;
import com.codegym.casestudy4.model.Items;
import com.codegym.casestudy4.repo.ICardItemsRepository;
import com.codegym.casestudy4.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private IProductService productService;
    @Autowired
    private ICardItemsRepository ICardItemsRepository;

    @Override
    public Iterable<Items> findAll() {
        return ICardItemsRepository.findAll();
    }

    @Override
    public Optional<Items> findById(Long id) {
        return ICardItemsRepository.findById(id);
    }

    @Override
    public Items save(Items items) {
        return ICardItemsRepository.save(items);
    }

    @Override
    public void delete(Long id) {
        ICardItemsRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteByProductId(Long id) {
        ICardItemsRepository.deleteByProduct_ProductId(id);
    }

    @Override
    public List<Items> getAllItemsByCart(Cart cart) {
        Iterable<Items> allItemsByCart = ICardItemsRepository.getAllByCart(cart);
        List<Items> items = new ArrayList<>();
        for (Items item : allItemsByCart) {
            items.add(item);
        }
        return items;
    }

    @Override
    public List<Items> getAllItemsByCartId(Long id) {
        Iterable<Items> allItemsByCart = ICardItemsRepository.getAllByCart_CartId(id);
        List<Items> items = new ArrayList<>();
        for (Items item : allItemsByCart) {
            items.add(item);
        }
        return items;
    }
}
