package com.example.springsecurity.common.service.impl;

import com.example.springsecurity.common.model.AuthenticationRuquest;
import com.example.springsecurity.common.model.UserDTO;
import com.example.springsecurity.common.service.AuthenticationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
@Transactional(readOnly = true)
public class AuthenticationServiceImpl implements AuthenticationService {

    @Override
    public UserDTO login(AuthenticationRuquest ruquest){
        //判断参数是否为空
        if(ruquest == null
        || ObjectUtils.isEmpty(ruquest.getUserName())
        || ObjectUtils.isEmpty(ruquest.getPassword())){
            throw new RuntimeException("用户名或密码不能为空!");
        }
        //查数据库
        UserDTO login = getUserDto(ruquest.getUserName());
        if(login == null){
            throw new RuntimeException("用户信息不存在!");
        }
        //校验密码
        if(!login.getPassword().equals(ruquest.getPassword())){
            throw new RuntimeException("用户名或密码不存在!");
        }
        return login;
    }

    private UserDTO getUserDto(String userName){
        return userMap.get(userName);
    }

    private Map<String, UserDTO> userMap = new HashMap<>();{

        Set<String> auth1 = new HashSet<>();
        auth1.add("p1");

        Set<String> auth2 = new HashSet<>();
        auth2.add("p2");

        userMap.put("daming", new UserDTO(1L, "daming", "123", "daming", auth1));
        userMap.put("erming", new UserDTO(2L, "erming", "123", "erming", auth2));
    }
}
