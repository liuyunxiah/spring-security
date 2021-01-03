package com.example.springsecurity.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
public class UserDTO implements Serializable {

    private Long id;

    private String userName;

    private String password;

    private String fullName;

    //权限列表
    private Set<String> authents;

}
