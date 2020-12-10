package com.codegym.casestudy4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admins")
public class AdminController {
    @GetMapping
    public String admin() {
        return "admin/admin-index";
    }
}
