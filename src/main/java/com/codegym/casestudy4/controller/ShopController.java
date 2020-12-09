package com.codegym.casestudy4.controller;

import com.codegym.casestudy4.model.AppUser;
import com.codegym.casestudy4.model.Shop;
import com.codegym.casestudy4.repo.IProductRepository;
import com.codegym.casestudy4.repo.IShopRepository;
import com.codegym.casestudy4.service.appuser.IAppUserService;
import com.codegym.casestudy4.service.shop.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
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

    @ModelAttribute("currentShop")
    public Shop currentShop(){
        Long id = iAppUserService.getUserLogin().getAppUserId();
       return iShopService.findByUserID(id);
    }


    @GetMapping
    public ModelAndView index(){
        ModelAndView modelAttribute = new ModelAndView("shop/shop-index");
        modelAttribute.addObject("products",productRepository.findAllByShop_ShopId(currentShop().getShopId()));
        return modelAttribute;
    }

    @GetMapping("/")
    public ResponseEntity<Iterable<Shop>> getAll() {
        return new ResponseEntity<>(iShopService.findAll(),HttpStatus.OK);
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

    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("shop/edit");
        modelAndView.addObject("shop", iShopService.findById(id));
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public void edit(@ModelAttribute Shop shop, HttpServletResponse response) {
        iShopService.save(shop);
        try {
            response.sendRedirect("/shops/list");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Shop> delete(@PathVariable Long id) {
        iShopService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
