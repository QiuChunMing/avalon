package com.example.avalon.repository;

import com.example.avalon.entity.StatisEntity;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;


public interface StatisRepository extends CrudRepository<StatisEntity, Integer> {
    long countByDate(LocalDate date);
}
