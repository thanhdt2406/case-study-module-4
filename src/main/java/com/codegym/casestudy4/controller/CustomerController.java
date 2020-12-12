package com.codegym.casestudy4.controller;

import com.codegym.casestudy4.model.*;
import com.codegym.casestudy4.service.appuser.IAppUserService;
import com.codegym.casestudy4.service.cart.ICartService;
import com.codegym.casestudy4.service.cartItems.ItemsService;
import com.codegym.casestudy4.service.category.ICategoryService;
import com.codegym.casestudy4.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private ItemsService itemsService;

    @Autowired
    private ICartService cartService;

    @Autowired
    private IAppUserService userService;

    @ModelAttribute("currentUser")
    public AppUser currentUser() {
        return userService.getUserLogin();
    }

    @ModelAttribute("currentCart")
    public Cart currentCart(){
        Cart cart = cartService.findByAppUser_AppUserId(currentUser().getAppUserId());
        if(cart == null){
            cart = new Cart(currentUser());
        }
        return cart;
    }

    @GetMapping("")
    public ModelAndView getAllProduct(@PageableDefault(size = 15) Pageable pageable, @RequestParam("searchName") Optional<String> name){
        Page<Product> productsList;
        if (name.isPresent()){
            productsList = productService.findAllByNameContaining(name.get(), pageable);
        }else {
            productsList = productService.findAll(pageable);
        }
        return new ModelAndView("customer/customer-index","products",productsList);
    }

    @GetMapping("/cart")
    public ModelAndView showCart(){
        ModelAndView modelAndView = new ModelAndView("customer/cart");
        return modelAndView;
    }

    @GetMapping("/addItem")
    public ModelAndView addItem(){
        ModelAndView modelAndView = new ModelAndView("customer/cart");
        return modelAndView;
    }

    @GetMapping("/addProductToCart")
    public ResponseEntity<List<Items>> addProductToCart(@PathVariable Long id) {
        productService.addProductToCart(id);
        List<Items> allItemsByCart = itemsService.getAllItemsByCart(currentCart());
        return new ResponseEntity<>(allItemsByCart ,HttpStatus.OK);
    }
}
