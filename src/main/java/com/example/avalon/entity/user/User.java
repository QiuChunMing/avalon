package com.example.avalon.entity.user;


import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
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
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Set<Role> roles;

}
