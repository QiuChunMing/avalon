package com.example.avalon.web.admin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {
    @RequestMapping("/add")
    public String add() {
        return "sa";
    }
}
