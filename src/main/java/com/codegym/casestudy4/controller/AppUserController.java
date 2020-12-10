package com.codegym.casestudy4.controller;

import com.codegym.casestudy4.model.Product;
import com.codegym.casestudy4.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping()
public class AppUserController {

    @Autowired
    private IProductService productService;

    @ModelAttribute("products")
    public Iterable<Product> products() {
        return productService.findAll();
    }


    @GetMapping
    public ModelAndView getAllProduct(@PageableDefault(size = 15) Pageable pageable, @RequestParam("name") Optional<String> name){
        Page<Product> products;
        if (name.isPresent()){
            products = productService.findAllByNameContaining(name.get(), pageable);
        }else {
            products = productService.findAll(pageable);
        }
        return new ModelAndView("index","products",products);
    }
//    toan lol

//xzczxzxcxc

}
