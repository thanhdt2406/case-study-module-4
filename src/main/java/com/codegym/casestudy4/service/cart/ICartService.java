package com.codegym.casestudy4.service.cart;

import com.codegym.casestudy4.model.Cart;
import com.codegym.casestudy4.service.IGeneralService;

public interface ICartService extends IGeneralService<Cart> {
    Cart findByAppUser_AppUserId(Long id);
}
