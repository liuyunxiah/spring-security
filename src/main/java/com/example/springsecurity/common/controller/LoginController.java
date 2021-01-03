package com.example.springsecurity.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class LoginController {
    //跳转页面
    @GetMapping("/login")
    public String home(){
        return "login";
    }
}
