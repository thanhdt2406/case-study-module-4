package com.codegym.casestudy4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class SecController {
    @GetMapping("/deny")
    public String denyAccess(){
        return "/deny";
    }
}
