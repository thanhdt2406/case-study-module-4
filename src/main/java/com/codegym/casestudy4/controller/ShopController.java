package com.codegym.casestudy4.controller;

import com.codegym.casestudy4.model.AppUser;
import com.codegym.casestudy4.model.Shop;

import com.codegym.casestudy4.repo.IProductRepository;
import com.codegym.casestudy4.repo.IShopRepository;
import com.codegym.casestudy4.service.appuser.IAppUserService;
import com.codegym.casestudy4.service.product.IProductService;
import com.codegym.casestudy4.service.shop.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/shops")
public class ShopController {
    @Autowired
    private IShopService iShopService;

    @Autowired
    private IAppUserService iAppUserService;

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private IProductService productService;

    @ModelAttribute("currentShop")
    public Shop currentShop() {
        Long id = iAppUserService.getUserLogin().getAppUserId();
        return iShopService.findByUserID(id);
    }


    @GetMapping
    public ModelAndView index() {
        ModelAndView modelAttribute = new ModelAndView("shop/shop-index");
        modelAttribute.addObject("products", productRepository.findAllByShop_ShopId(currentShop().getShopId()));
        return modelAttribute;
    }
    @GetMapping("/product-detail/{id}")
    public ModelAndView productDetail(@PathVariable("id") Long id){
        return new ModelAndView("shop/product-details-shop","product",productService.findById(id));
    }

    @GetMapping("/")
    public ResponseEntity<Iterable<Shop>> getAll() {
        return new ResponseEntity<>(iShopService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ModelAndView showShopList() {
        ModelAndView modelAndView = new ModelAndView("/shop/list");
        Iterable<Shop> shops = iShopService.findAll();
        modelAndView.addObject("shopList", shops);
        return modelAndView;
    }

    @PostMapping("/create")
    public ResponseEntity<Shop> create(@RequestBody Shop shop) {
        iShopService.save(shop);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/edit")
    public ModelAndView editForm() {
        ModelAndView modelAndView = new ModelAndView("shop/shop-profile");
        modelAndView.addObject("shop", iShopService.findById(currentShop().getShopId()));
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView edit(@Valid @ModelAttribute Shop shop, HttpServletResponse response) {
        iShopService.save(shop);
        ModelAndView modelAndView = new ModelAndView("shop/shop-profile");
        modelAndView.addObject("shop",shop);
        modelAndView.addObject("message", "UPDATE OK");
        return modelAndView;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Shop> delete(@PathVariable Long id) {
        iShopService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
