package com.codegym.casestudy4.repo;

import com.codegym.casestudy4.model.Cart;
import com.codegym.casestudy4.model.Items;
import com.codegym.casestudy4.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.nio.file.LinkOption;
@Repository
public interface ICardItemsRepository extends CrudRepository<Items, Long> {
    Iterable<Items> getAllByCart(Cart cart);
    Iterable<Items> getAllByCart_CartId(Long id);
    Items getByCartIsAndProductIs(Cart cart, Product product);
    void deleteByProduct_ProductId(Long id);
}
