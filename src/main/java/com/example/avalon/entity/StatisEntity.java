package com.example.avalon.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class StatisEntity {
    @Id
    @GeneratedValue
    private int id;

    private LocalDate date;

    private String origin;
}
