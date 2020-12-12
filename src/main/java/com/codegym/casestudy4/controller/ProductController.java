package com.codegym.casestudy4.controller;

import com.codegym.casestudy4.model.AppUser;
import com.codegym.casestudy4.model.Category;
import com.codegym.casestudy4.model.Product;
import com.codegym.casestudy4.model.Shop;
import com.codegym.casestudy4.service.appuser.IAppUserService;
import com.codegym.casestudy4.service.category.ICategoryService;
import com.codegym.casestudy4.service.product.IProductService;
import com.codegym.casestudy4.service.shop.IShopService;
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
    private IAppUserService iAppUserService;

    @Autowired
    private IShopService iShopService;

    @Autowired
    private Environment env;

    @Autowired
    private IAppUserService appUserService;
    @Autowired
    private IShopService shopService;

    @ModelAttribute("currentUser")
    public AppUser currentUser(){
        return appUserService.getUserLogin();
    }

    @ModelAttribute("category")
    public Iterable<Category> categories() {
        return iCategoryService.findAll();
    }

    @ModelAttribute("currentShop")
    public Shop currentShop() {
        Long id = iAppUserService.getUserLogin().getAppUserId();

        return iShopService.findByUserID(id);
    }


//    @Value("${upload.path}")
//    private String fileUpload;

    @GetMapping("/detail/{id}")
    public ModelAndView showProductDetail(@PathVariable("id") Long id){
        return new ModelAndView("customer/product-details","product",productService.findById(id).get());
    }

    @GetMapping("/product-detail/{id}")
    public ModelAndView productDetail_Shop(@PathVariable("id") Long proId){
        ModelAndView modelAndView = new ModelAndView("shop/product-details-shop");
        Long id = appUserService.getUserLogin().getAppUserId();

        modelAndView.addObject("product",productService.findById(proId).get());
        modelAndView.addObject("currentShop",shopService.findByUserID(id));
        return modelAndView;
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
        ModelAndView modelAndView = new ModelAndView("shop/add-new-product");
        modelAndView.addObject("products", new Product());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView creatNewProduct(@ModelAttribute Product product){
//        Product productDB = new Product(product.getName(), product.getPrice(), product.getQuantity(), product.getCreateDate(), product.getViews(), product.getRating(), product.isStatus(), product.getShop().getName(), product.getCategory().getName());
        MultipartFile multipartFile = product.getProductImage();
        String fileName = multipartFile.getOriginalFilename();
        String fileUpload = env.getProperty("upload.path").toString();
        try {
            FileCopyUtils.copy(multipartFile.getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        product.setImage(fileName);

//        product.setImage(fileName);
//        Product productDB = new Product(product.getName(), product.getPrice(), product.getQuantity(), fileName, product.getDescription(), product.getCreateDate(), product.getViews(), product.getRating(), product.isStatus(), product.getShop(), product.getCategory());
        product.setShop(currentShop());
        product.setStatus(true);
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("shop/add-new-product");
        modelAndView.addObject("products", new Product());
        modelAndView.addObject("message", "ADD PRODUCT OK");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    ModelAndView showEditForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("shop/product-details-shop");
        modelAndView.addObject("product",productService.findById(id));
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView editProduct(@ModelAttribute Product product) {
        Product product1 = productService.findById(product.getProductId()).get();
        MultipartFile multipartFile = product.getProductImage();
        String image = multipartFile.getOriginalFilename();
        if (image.isEmpty()) {
            image = product1.getImage();
        }else {
            image = multipartFile.getOriginalFilename();
        }
        product.setImage(image);
        product.setStatus(true);
        product.setShop(currentShop());
        String fileUpload = env.getProperty("upload.path").toString();
        try {
            FileCopyUtils.copy(multipartFile.getBytes(), new File(fileUpload + image));
        } catch (IOException e) {
            e.printStackTrace();
        }
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("shop/product-details-shop");
        modelAndView.addObject("product", product);
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
