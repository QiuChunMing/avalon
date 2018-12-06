package com.example.avalon.entity;


import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
public class User {
    public User() {
    }

    private String userName;

    private String password;

    private int id;

    private LocalDate createTime;

    private Role role;

    private String avator;

    private String city;

}
