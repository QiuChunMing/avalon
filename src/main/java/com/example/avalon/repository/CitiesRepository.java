package com.example.avalon.repository;

import com.example.avalon.entity.Cities;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CitiesRepository extends CrudRepository<Cities,Integer> {
    Cities findFirstByName(String name);

    List<Cities> findByisHotCityTrue();

    Cities findFirstById(Integer id);

}
