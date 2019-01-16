package com.example.avalon.repository;

import com.example.avalon.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserByUserName(String name);
}
