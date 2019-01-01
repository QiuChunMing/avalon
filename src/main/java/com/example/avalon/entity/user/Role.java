package com.example.avalon.entity.user;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Role {

    @Id
    @GeneratedValue
    private int id;

    private String role;


}
