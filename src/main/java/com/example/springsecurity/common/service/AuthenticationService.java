package com.example.springsecurity.common.service;


import com.example.springsecurity.common.model.AuthenticationRuquest;
import com.example.springsecurity.common.model.UserDTO;

public interface AuthenticationService {
    UserDTO login(AuthenticationRuquest ruquest);
}
