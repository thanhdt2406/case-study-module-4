package com.codegym.casestudy4.controller;

import com.codegym.casestudy4.model.*;
import com.codegym.casestudy4.service.appuser.IAppUserService;
import com.codegym.casestudy4.service.cart.ICartService;
import com.codegym.casestudy4.service.cartItems.ItemsService;
import com.codegym.casestudy4.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/items")
public class ItemsController {
    @Autowired
    private IAppUserService appUserService;
    @Autowired
    private IProductService productService;
    @Autowired
    private ICartService cartService;
    @Autowired
    private ItemsService itemsService;
    @ModelAttribute()
    public AppUser currentUser() {
        return appUserService.getUserLogin();
    }

    public Cart currentCart(){
        Cart cart = cartService.findByAppUser_AppUserId(currentUser().getAppUserId());
        if(cart == null){
            cart = new Cart(currentUser());
        }
        return cart;
    }

//    @GetMapping
//    public ResponseEntity<Items> addCart(@PathVariable Long id) {
//        Product product = productService.findById(id).get();
//        Items items=new Items();
//        items.setCart(currentCart());
//        items.setProduct(product);
////        itemsService.xulisanpham(id,currentCart())
//        itemsService.save(items);
//    }
}
