package com.example.avalon.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Role {

    @Id
    @GeneratedValue
    private int id;

    private String role;

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = {@JoinColumn(name =
            "role_id", referencedColumnName = "id")}
    )
    private Set<User> user = new HashSet<>();

}
