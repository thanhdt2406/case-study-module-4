package com.codegym.casestudy4.controller;

import com.codegym.casestudy4.model.AppUser;
import com.codegym.casestudy4.model.Cart;
import com.codegym.casestudy4.service.approle.IAppRoleService;
import com.codegym.casestudy4.service.appuser.IAppUserService;
import com.codegym.casestudy4.service.cart.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping()
public class SecController {
    @Autowired
    private IAppUserService appUserService;

    @Autowired
    private IAppRoleService appRoleService;

    @Autowired
    private ICartService cartService;

    @ModelAttribute("currentUser")
    public AppUser currentUser() {
        return appUserService.getUserLogin();
    }

    @GetMapping("/deny")
    public String denyAccess() {
        return "deny";
    }


    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView = null;
        if (currentUser() == null) {
            modelAndView = new ModelAndView("login", "appuser", new AppUser());
        } else {
//            switch (currentUser().getAppRole().getName()) {
//                case "ROLE_ADMIN":
//                    modelAndView = new ModelAndView("redirect:/admins");
//                    break;
//                case "ROLE_SHOP":
//                    modelAndView = new ModelAndView("redirect:/shops");
//                    break;
//                case "ROLE_USER":
//                    modelAndView = new ModelAndView("redirect:/users");
//                    break;
//            }
            modelAndView = new ModelAndView("redirect:/customer");
        }
        return modelAndView;
    }

    @PostMapping("/signup")
    public ModelAndView createNewUser(@Valid @ModelAttribute AppUser appUser, BindingResult bindingResult) {
        if (isExistUsername(appUser.getUsername()) || bindingResult.hasErrors()) {
            return new ModelAndView("redirect:/login?signupfailed");
        } else {
            appUser.setAppRole(appRoleService.findByName("ROLE_USER"));
            appUser.setStatus(true);
            appUserService.save(appUser);
            return new ModelAndView("redirect:/login?signupsuccess");
        }
    }

    private boolean isExistUsername(String username) {
        List<AppUser> appUserList = (List<AppUser>) appUserService.findAll();
        for (AppUser appUser : appUserList) {
            if (appUser.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

}
