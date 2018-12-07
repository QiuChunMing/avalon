package com.example.avalon.repository;

import com.example.avalon.entity.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category,Integer> {
    List<Category> findAllByLevel(Integer level);

    List<Category> findAll();
}
