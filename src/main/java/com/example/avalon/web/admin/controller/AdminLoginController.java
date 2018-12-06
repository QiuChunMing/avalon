package com.example.avalon.web.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController()
public class AdminLoginController {

    @RequestMapping()
    public String Login(HttpServletRequest request) {
       return null;
    }
}
