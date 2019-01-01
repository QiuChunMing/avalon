package com.example.avalon.repository;

import com.example.avalon.entity.food.FoodAttribute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodAttributeRepository extends JpaRepository<FoodAttribute,Integer> {
}
