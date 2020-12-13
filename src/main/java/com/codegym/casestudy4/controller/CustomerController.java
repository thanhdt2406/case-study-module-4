package com.codegym.casestudy4.controller;

import com.codegym.casestudy4.model.*;
import com.codegym.casestudy4.service.appuser.IAppUserService;
import com.codegym.casestudy4.service.cart.ICartService;
import com.codegym.casestudy4.service.cartItems.ItemsService;
import com.codegym.casestudy4.service.category.ICategoryService;
import com.codegym.casestudy4.service.order.IOrderedService;
import com.codegym.casestudy4.service.orderDetail.IOrderDetailService;
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

    @Autowired
    private IOrderedService orderedService;

    @Autowired
    private IOrderDetailService orderDetailService;

    @ModelAttribute("currentUser")
    public AppUser currentUser() {
        return userService.getUserLogin();
    }

    @ModelAttribute("currentCart")
    public Cart currentCart() {
        Cart cart = cartService.findByAppUser_AppUserId(currentUser().getAppUserId());
        if (cart == null) {
            cart = new Cart(currentUser());
            cartService.save(cart);
        }
        return cart;
    }

    @GetMapping("")
    public ModelAndView getAllProduct(@PageableDefault(size = 15) Pageable pageable, @RequestParam("searchName") Optional<String> name) {
        Page<Product> productsList;
        if (name.isPresent()) {
            productsList = productService.findAllByNameContaining(name.get(), pageable);
        } else {
            productsList = productService.findAll(pageable);
        }
        return new ModelAndView("customer/customer-index", "products", productsList);
    }

    @GetMapping("/cart")
    public ModelAndView showCart() {
        List<Items> allItemsByCart = itemsService.getAllItemsByCart(currentCart());
        ModelAndView modelAndView = new ModelAndView("customer/cart");
        modelAndView.addObject("allItems", allItemsByCart);
        return modelAndView;
    }

    @GetMapping("/addItem")
    public ModelAndView addItem() {
        ModelAndView modelAndView = new ModelAndView("customer/cart");
        return modelAndView;
    }

    @GetMapping("/addProductToCart/{id}")
    public ResponseEntity<List<Items>> addProductToCart(@PathVariable Long id) {
        productService.addProductToCart(id);
        List<Items> allItemsByCart = itemsService.getAllItemsByCart(currentCart());
        return new ResponseEntity<>(allItemsByCart, HttpStatus.OK);
    }

    @GetMapping("/minusProduct/{id}")
    public ResponseEntity<List<Items>> minusProductToItem(@PathVariable Long id) {
        productService.minusProductQuantity(id);
        List<Items> allItemsByCart = itemsService.getAllItemsByCart(currentCart());
        return new ResponseEntity<>(allItemsByCart, HttpStatus.OK);
    }

    @DeleteMapping("/cart/delete/{id}")
    public ResponseEntity<List<Items>> deleteItem(@PathVariable Long id) {
        itemsService.deleteByProductId(id);
        List<Items> allItemsByCart = itemsService.getAllItemsByCart(currentCart());
        return new ResponseEntity<>(allItemsByCart, HttpStatus.OK);
    }

//    private void createNewOrder(){
//        Ordered ordered = new Ordered(currentUser());
//        orderedService.save(ordered);
//    }

    @PostMapping("/order")
    public ModelAndView order(@RequestParam("cartID") Long id) {
        List<Items> items = itemsService.getAllItemsByCartId(id);
        Ordered ordered = new Ordered(currentUser());
        orderedService.save(ordered);
        boolean isEmpty = true;
        for (Items item : items) {
            if (item.getQuantity() > productService.findById(item.getProduct().getProductId()).get().getQuantity()) {
                isEmpty = false;
                continue;
            }
            OrderDetail orderDetail = new OrderDetail(item.getQuantity(), ordered, item.getProduct());
            orderDetailService.save(orderDetail);
            productService.minusProductByProductId(item.getQuantity(), item.getProduct().getProductId());
            itemsService.delete(item.getItemId());
        }
        if (isEmpty) {
            cartService.delete(id);
        }
        return new ModelAndView("redirect:/customer/ordered");
    }

    @GetMapping("/ordered")
    public ModelAndView showOrder() {
        List<Ordered> orderedList = (List<Ordered>) orderedService.findAllByAppUser(currentUser());
        return new ModelAndView("customer/ordered", "orderedList", orderedList);
    }

    @GetMapping("/order/detail/{id}")
    public ModelAndView showDetailOrder(@PathVariable("id") Long id) {
        Iterable<OrderDetail> orderDetailList = orderDetailService.findAllByOrdered(id);
        return new ModelAndView("/customer/order-detail", "orderDetailList", orderDetailList);
    }
}
