package com.codegym.casestudy4.controller;

import com.codegym.casestudy4.model.AppUser;
import com.codegym.casestudy4.service.appuser.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping()
public class SecController {
    @Autowired
    private IAppUserService appUserService;

    @ModelAttribute("currentUser")
    public AppUser currentUser(){
        return appUserService.getUserLogin();
    }

    @GetMapping("/deny")
    public String denyAccess() {
        return "/deny";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/users")
    public String user() {
        return "user";
    }



    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView ("login","appuser",new AppUser());
    }


}
