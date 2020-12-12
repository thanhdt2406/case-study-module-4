package com.codegym.casestudy4.service.product;

import com.codegym.casestudy4.model.*;
import com.codegym.casestudy4.repo.IProductRepository;
import com.codegym.casestudy4.repo.ItemsRepository;
import com.codegym.casestudy4.service.appuser.IAppUserService;
import com.codegym.casestudy4.service.cart.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ICartService cartService;
    @Autowired
    private IAppUserService userService;

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

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private ItemsRepository itemsRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Page<Product> findAllByNameContaining(String name, Pageable pageable) {
        return productRepository.findAllByNameContaining(name, pageable);
    }

    @Override
    public Iterable<Product> findAllProductAvailable(Long shopId) {
        return productRepository.findAllByShop_ShopIdAndStatusTrue(shopId);
    }

    @Override
    public Page<Product> findAllByName(String name, Pageable pageable) {
        return productRepository.findAllByName(name, pageable);
    }

    @Override
    public Iterable<Product> findAllByCategory(Category category) {
        return productRepository.findAllByCategory(category);
    }

    @Override
    public Iterable<Product> findAllByPriceBetween(Long min, Long max) {
        return productRepository.findAllByPriceBetween(min,max);
    }

    @Override
    public Iterable<Product> findAllByPriceDesc() {
        return productRepository.findAllByOrderByPriceDesc();
    }

    @Override
    public Iterable<Product> findAllProductOrderByStarsDesc() {
        return productRepository.findAllProductOrderByStarsDesc();
    }
//lay sptrong 1cart truyen vao`
    @Override
    public List<Product> findAllProductByCart(Cart cart) {
        Iterable<Items> itemsList = itemsRepository.getAllByCart(currentCart());

        List<Product> productList=new ArrayList<>();
        for (Items item:itemsList
             ) {
            productList.add(item.getProduct());
        };
        return productList;
    }

    @Override
    public void addProductToCart(Long id) {
        Product product = productRepository.findById(id).get();
        List<Product> allProductByCart = this.findAllProductByCart(currentCart());
        boolean isContains = allProductByCart.contains(product);
        if (isContains){
            Items currentItems = itemsRepository.getByCartIsAndProductIs(currentCart(), product);
            int currentQuantity = currentItems.getQuantity();
            currentQuantity++;
            currentItems.setQuantity(currentQuantity);
            itemsRepository.save(currentItems);
        }
        else {
            Items newItem=new Items();
            newItem.setQuantity(1);
            newItem.setProduct(product);
            newItem.setCart(currentCart());
            itemsRepository.save(newItem);
        }

    }

    @Override
    public void minusProductQuantity(Long id) {
        Product product = productRepository.findById(id).get();
        Items currentItem = itemsRepository.getByCartIsAndProductIs(currentCart(), product);
        int quantity = currentItem.getQuantity();
        Long itemId = currentItem.getItemId();
        if (quantity==1) {
            itemsRepository.deleteById(itemId);
        }else {
            quantity--;
            currentItem.setQuantity(quantity);
            itemsRepository.save(currentItem);
        }
    }

    @Override
    public Iterable<Product> findAllByPriceAsc() {
        return productRepository.findAllByOrderByPriceAsc();
    }
}
