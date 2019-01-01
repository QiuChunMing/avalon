package com.example.avalon.repository;

import com.example.avalon.entity.food.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu,Integer> {
}
