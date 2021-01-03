package com.example.springsecurity.common.controller;

import com.example.springsecurity.common.model.AuthenticationRuquest;
import com.example.springsecurity.common.model.UserDTO;
import com.example.springsecurity.common.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

/**
 * 基于session的认证授权过程
 */
@RestController
@RequestMapping("/sessiondemo")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping(value = "/login", produces = "text/plain;charset=UTF-8")
    public String login(AuthenticationRuquest ruquest, HttpSession httpSession){
        UserDTO user = authenticationService.login(ruquest);
        httpSession.setAttribute("_user", user);
        return user.getUserName() + "登录成功!";
    }

    @GetMapping(value = "/logout", produces = "text/plain;charset=UTF-8")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
        return "登出成功";
    }

    @GetMapping(value = "/resource/test1", produces = "text/plain;charset=UTF-8")
    public String test(HttpSession httpSession){
        String fullName = "";
        Object user = httpSession.getAttribute("_user");
        if(user == null){
            fullName = "匿名";
        }else{
            fullName = ((UserDTO)user).getUserName();
        }
        return fullName + "访问资源";
    }

    @GetMapping(value = "/resource/test2", produces = "text/plain;charset=UTF-8")
    public String test1(HttpSession httpSession){
        String fullName = "";
        Object user = httpSession.getAttribute("_user");
        if(user == null){
            fullName = "匿名";
        }else{
            fullName = ((UserDTO)user).getUserName();
        }
        return fullName + "访问资源1";
    }


}
