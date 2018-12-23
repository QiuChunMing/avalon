package com.example.avalon.entity;


import lombok.Data;

import java.time.LocalDate;

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
