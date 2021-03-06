package com.codegym.casestudy4.controller;

import com.codegym.casestudy4.model.AppUser;
import com.codegym.casestudy4.model.Category;
import com.codegym.casestudy4.model.Product;
import com.codegym.casestudy4.service.appuser.IAppUserService;
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

import java.util.Optional;

@Controller
@RequestMapping()
public class AppUserController {
    @Autowired
    private IAppUserService appUserService;

    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("currentUser")
    public AppUser currentUser() {
        return appUserService.getUserLogin();
    }

    @GetMapping("")
    public ModelAndView getAllProduct(@PageableDefault(size = 15) Pageable pageable, @RequestParam("searchName") Optional<String> name){
        if(currentUser()!=null){
            return new ModelAndView("redirect:/customer");
        }
        Page<Product> productsList;
        if (name.isPresent()){
            productsList = productService.findAllByNameContaining(name.get(), pageable);
        }else {
            productsList = productService.findAll(pageable);
        }
        return new ModelAndView("index","products",productsList);
    }

    @GetMapping("/banned")
    public ModelAndView bannedNoti(){
        return new ModelAndView("loginNotification");
    }

    @GetMapping("/categoryname")
    public ResponseEntity<Iterable<Product>> getAllProByCategory(@RequestParam(value = "name",required = false) String categoryName) {
        Optional<Category> category = categoryService.findCategoryByName(categoryName);
        Iterable<Product> allProductByCategory = productService.findAllByCategory(category.get());
        return new ResponseEntity<>(allProductByCategory, HttpStatus.OK);
    }

    @GetMapping("/sort")
    public ResponseEntity<Iterable<Product>> getAllProSort(@RequestParam(value = "name",required = true) String sortName) {
        Iterable<Product> responseEntity = null;
        switch (sortName){
            case "stars":
                responseEntity = productService.findAllProductOrderByStarsDesc();
                break;
            case "pricedesc":
                responseEntity = productService.findAllByPriceDesc();
                break;
            case "priceasc":
                responseEntity = productService.findAllByPriceAsc();
                break;
        }
        return new ResponseEntity<>(responseEntity, HttpStatus.OK);
    }


    @GetMapping("/price")
    public ResponseEntity<Iterable<Product>> getAllProByPrice(@RequestParam(value = "min",required = false) Long min,@RequestParam(value = "max",required = false) Long max){
        Iterable<Product> allProductByPrice = productService.findAllByPriceBetween(min,max);
        return new ResponseEntity<>(allProductByPrice,HttpStatus.OK);
    }
}
