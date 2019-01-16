package com.example.avalon.entity;


import com.example.avalon.entity.Role;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Data
public class User implements UserDetails {
    public User() {
    }

    @Id
    @GeneratedValue
    private int id;
    private String userName;
    private String password;
    private LocalDate createTime;
    private String avatar;
    private String city;
    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = {@JoinColumn(name =
            "user_id", referencedColumnName = "id")}
    )
    private Set<Role> roles = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorityList;
        if (!(roles.size() > 0)) {
            authorityList = AuthorityUtils.NO_AUTHORITIES;
        } else {
            authorityList = new ArrayList<>();
            for (Role role : roles) {
                authorityList.add(new SimpleGrantedAuthority("ROLE_"+role.getRole()));
            }
        }
        return authorityList;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
