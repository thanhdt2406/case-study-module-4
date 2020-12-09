package com.codegym.casestudy4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class AppUserController {
    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/user")
    public String user(){
        return "user";
    }
    @GetMapping("/shop")
    public String shop(){
        return "shop/shop-index";
    }
    @GetMapping("/admin")
    public String admin(){
        return "admin/admin";
    }

}
