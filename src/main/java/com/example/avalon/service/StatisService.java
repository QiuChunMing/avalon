package com.example.avalon.service;

import com.example.avalon.entity.StatisEntity;
import com.example.avalon.repository.StatisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StatisService {
    @Autowired
    private StatisRepository statisRepository;

    public ServiceResult<Long> requestDateCount(LocalDate date) {
        return ServiceResult.of(statisRepository.countByDate(date));
    }


    public ServiceResult<Long> requestAllCount() {
        return ServiceResult.of(statisRepository.count());
    }

    public ServiceResult<Iterable<StatisEntity>> requestAll() {
        Iterable<StatisEntity> entities = statisRepository.findAll();
        return ServiceResult.of(entities);
    }


}
