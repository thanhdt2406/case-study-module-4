package com.codegym.casestudy4.controller;

import com.codegym.casestudy4.model.Category;
import com.codegym.casestudy4.model.Product;
import com.codegym.casestudy4.service.category.ICategoryService;
import com.codegym.casestudy4.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.io.File;
import java.io.IOException;
import java.util.Optional;


@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService iCategoryService;

    @Autowired
    private Environment env;

    @ModelAttribute("category")
    public Iterable<Category> categories() {
        return iCategoryService.findAll();
    }

//    @Value("${upload.path}")
//    private String fileUpload;

    @GetMapping("/details/{id}")
    public ModelAndView showProductDetail(@PathVariable("id") Long id){
        return new ModelAndView("product-details","product",productService.findById(id).get());
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Product> getProductDetail(@PathVariable("id") Long id){
        return new ResponseEntity<>(productService.findById(id).get(), HttpStatus.OK);
    }
// hoi quan giai thich lai phan paging
    @GetMapping("")
    public ModelAndView getAllProduct(@PageableDefault(size = 15) Pageable pageable, @RequestParam("name") Optional<String> name){
        Page<Product> products;
        if (name.isPresent()){
           products = productService.findAllByNameContaining(name.get(), pageable);
        }else {
            products = productService.findAll(pageable);
        }
        return new ModelAndView("index","products",productService.findAll());
    }


    @GetMapping("/create")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView = new ModelAndView("/shop/createForm");
        modelAndView.addObject("shop/createForm", new Product());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView creatTask(@ModelAttribute Product product){
//        Product productDB = new Product(product.getName(), product.getPrice(), product.getQuantity(), product.getCreateDate(), product.getViews(), product.getRating(), product.isStatus(), product.getShop().getName(), product.getCategory().getName());
        MultipartFile multipartFile = product.getProductImage();
        String fileName = multipartFile.getOriginalFilename();
        String fileUpload = env.getProperty("upload.path").toString();
        try {
            FileCopyUtils.copy(multipartFile.getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
//        product.setImage(fileName);
        Product productDB = new Product(product.getName(), product.getPrice(), product.getQuantity(), fileName, product.getDescription(), product.getCreateDate(), product.getViews(), product.getRating(), product.isStatus(), product.getShop(), product.getCategory());

        productService.save(productDB);
        ModelAndView modelAndView = new ModelAndView("/shop/createForm");
        modelAndView.addObject("products", new Product());
        modelAndView.addObject("message", "ADD PRODUCT OK");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    ModelAndView showEditForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("shop/editForm");
        modelAndView.addObject("products",productService.findById(id));
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView editProduct(@ModelAttribute Product product) {
        Product product1 = productService.findById(product.getProductId()).get();
        MultipartFile multipartFile = product.getProductImage();
        String image = null;
        if (image.isEmpty()) {
            image = product1.getImage();
        }else {
            image = multipartFile.getOriginalFilename();
        }
        product1.setImage(image);
        String fileUpload = env.getProperty("upload.path").toString();
        try {
            FileCopyUtils.copy(multipartFile.getBytes(), new File(fileUpload + image));
        } catch (IOException e) {
            e.printStackTrace();
        }
        productService.save(product1);
        ModelAndView modelAndView = new ModelAndView("shop/editForm");
        modelAndView.addObject("products", product);
        modelAndView.addObject("message", "UPDATE OKKKKKK");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PageableDefault(size = 15) @PathVariable Long id, Pageable pageable){
//        Product product = productService.findById(id).get();
//        productService.delete(product.getProductId());
        productService.delete(id);
        Page<Product> products = productService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/shop/list");
        modelAndView.addObject("products", products);
        return modelAndView;
    }
}
