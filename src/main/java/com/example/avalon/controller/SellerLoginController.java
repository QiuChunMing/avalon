package com.example.avalon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/seller")
@Controller
public class SellerLoginController {
    @RequestMapping("/login")
    public String login() {
        return "admin/login";
    }

}
