package com.codegym.casestudy4.service.cartItems;

import com.codegym.casestudy4.model.Cart;
import com.codegym.casestudy4.model.Items;
import com.codegym.casestudy4.service.IGeneralService;

import java.util.List;

public interface ItemsService extends IGeneralService<Items> {
    List<Items> getAllItemsByCart(Cart cart);

    List<Items> getAllItemsByCartId(Long id);

    void deleteByProductId(Long id);
}
