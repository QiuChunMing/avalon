package com.example.avalon.repository;

import com.example.avalon.entity.food.FoodSpec;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodSpecRepository extends JpaRepository<FoodSpec,Integer> {
}
