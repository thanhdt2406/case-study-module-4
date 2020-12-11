package com.codegym.casestudy4.controller;

import com.codegym.casestudy4.model.AppUser;
import com.codegym.casestudy4.model.Shop;
import com.codegym.casestudy4.service.appuser.IAppUserService;
import com.codegym.casestudy4.service.shop.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admins")
public class AdminController {
    @Autowired
    private IAppUserService appUserService;

    @Autowired
    private IShopService shopService;

    @GetMapping
    public ModelAndView admin(@PageableDefault(size = 10) Pageable pageable) {
        Page<AppUser> users = appUserService.findAppUserAvailable(pageable,"ROLE_ADMIN",true);
        return new ModelAndView("admin/admin-index","users",users);
    }

    @GetMapping("/block/{id}")
    public ModelAndView blockUser(@PathVariable("id") Long id,@PageableDefault(size = 10) Pageable pageable){
        appUserService.changeUserStatus(id);
        return new ModelAndView("redirect:/admins");
    }

    @GetMapping("/users-violation")
    public ModelAndView violationUser(@PageableDefault(size = 10) Pageable pageable){
        Page<AppUser> users = appUserService.findAppUserAvailable(pageable,"ROLE_ADMIN",false);
        return new ModelAndView("admin/admin-index","users",users);
    }

    @GetMapping("/unblock/{id}")
    public ModelAndView unblockUser(@PathVariable("id") Long id,@PageableDefault(size = 10) Pageable pageable){
        appUserService.changeUserStatus(id);
        return new ModelAndView("redirect:/admins/users-violation");
    }

    @GetMapping("/shops")
    public ModelAndView shop(@PageableDefault(size = 10) Pageable pageable) {
        Page<Shop> shops = shopService.findShopAvailable(pageable,true);
        return new ModelAndView("admin/admin-shop","shops",shops);
    }

    @GetMapping("/block-shop/{id}")
    public ModelAndView blockShop(@PathVariable("id") Long id,@PageableDefault(size = 10) Pageable pageable){
        shopService.changeShopStatus(id);
        return new ModelAndView("redirect:/admins/shops");
    }

    @GetMapping("/shops-violation")
    public ModelAndView violationShop(@PageableDefault(size = 10) Pageable pageable) {
        Page<Shop> shops = shopService.findShopAvailable(pageable,false);
        return new ModelAndView("admin/admin-shop","shops",shops);
    }

    @GetMapping("/unblock-shop/{id}")
    public ModelAndView unblockShop(@PathVariable("id") Long id,@PageableDefault(size = 10) Pageable pageable){
        shopService.changeShopStatus(id);
        return new ModelAndView("redirect:/admins/shops-violation");
    }
}
