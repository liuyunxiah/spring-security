package com.example.springsecurity.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
@Data
@AllArgsConstructor
public class AuthenticationRuquest implements Serializable {

    private String userName;

    private String password;
}
