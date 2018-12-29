package com.example.avalon.entity.shop;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
public class Identification {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer restaurantId;
    private String companyName;
    private String identificateAgency;
    private LocalDate identificateDate;
    private String legalPerson;
    private String licensesDate;
    private String licensesScope;
    private String licensesNumber;
    private String operationPeriod;
    private String registeredAddress;
    private String registeredNumber;
}
