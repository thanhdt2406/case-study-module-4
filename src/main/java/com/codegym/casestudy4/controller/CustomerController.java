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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IAppUserService userService;

    @ModelAttribute("currentUser")
    public AppUser currentUser() {
        return userService.getUserLogin();
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

    @GetMapping("/categoryname")
    public ResponseEntity<Iterable<Product>> getAllProByCategory(@RequestParam(value = "name",required = false) String categoryName) {
        Optional<Category> category = categoryService.findCategoryByName(categoryName);
        Iterable<Product> allProductByCategory = productService.findAllByCategory(category.get());
        return new ResponseEntity<>(allProductByCategory, HttpStatus.OK);


    }
}
