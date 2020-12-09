package com.codegym.casestudy4.controller;

import com.codegym.casestudy4.model.Product;
import com.codegym.casestudy4.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/details/{id}")
    public ModelAndView showProductDetail(@PathVariable("id") Long id){
        return new ModelAndView("product-details","product",productService.findById(id).get());
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Product> getProductDetail(@PathVariable("id") Long id){
        return new ResponseEntity<>(productService.findById(id).get(), HttpStatus.OK);
    }




}
