package com.codegym.casestudy4.controller;

import com.codegym.casestudy4.model.AppUser;
import com.codegym.casestudy4.model.Product;
import com.codegym.casestudy4.model.Shop;

import com.codegym.casestudy4.repo.IProductRepository;
import com.codegym.casestudy4.repo.IShopRepository;
import com.codegym.casestudy4.service.appuser.IAppUserService;
import com.codegym.casestudy4.service.product.IProductService;
import com.codegym.casestudy4.service.shop.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/shops")
public class ShopController {
    @Autowired
    private IShopService iShopService;

    @Autowired
    private IAppUserService iAppUserService;

    @Autowired
    private IProductService productService;

    @ModelAttribute("currentShop")
    public Shop currentShop() {
        Long id = iAppUserService.getUserLogin().getAppUserId();
        return iShopService.findByUserID(id);
    }
    @ModelAttribute("currentUser")
    public AppUser currentUser() {
        return iAppUserService.getUserLogin();
    }

    @GetMapping
    public ModelAndView index() {
        ModelAndView modelAttribute = new ModelAndView("shop/shop-index");
        modelAttribute.addObject("products", productService.findAllProductAvailable(currentShop().getShopId()));
        return modelAttribute;
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

//    @PostMapping("/create")
//    public ResponseEntity<Shop> create(@RequestBody Shop shop) {
//        iShopService.save(shop);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    @GetMapping("/edit")
    public ModelAndView editForm() {
        ModelAndView modelAndView = new ModelAndView("shop/shop-profile");
        Shop shop =iShopService.findById(currentShop().getShopId()).get();
        modelAndView.addObject("shop", shop);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView edit(@Valid @ModelAttribute Shop shop) {
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
