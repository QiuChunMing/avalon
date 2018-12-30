package com.example.avalon.repository;

import com.example.avalon.entity.shop.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ShopRepository extends JpaRepository<Shop,Integer> {
    Shop findByName(String name);
}
