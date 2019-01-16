package com.example.avalon.security;

import com.example.avalon.entity.User;
import com.example.avalon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component("userDetailServiceImp")
public class UserDetailServiceImp implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!StringUtils.hasText(username)) {
            throw new UsernameNotFoundException("password can not be empty");
        }
        User loadedUser = userRepository.findUserByUserName(username);
        if (loadedUser == null) {
            throw new UsernameNotFoundException("can not find userName");
        }
        return loadedUser;
    }
}
