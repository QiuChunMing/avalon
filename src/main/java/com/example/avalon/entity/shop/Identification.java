package com.example.avalon.entity.shop;

import lombok.Data;

import javax.persistence.Entity;
import java.time.LocalDate;

@Data
//@Entity
public class Identification {


    private String companyName;

    private String identificateAngency;

    private LocalDate identificateDate;

    private String legalPreson;

    private String licensesDate;

    private String licensesScope;

    private String licensesNumber;

    private String operationPerid;

    private String registeredAdress;

    private String registeredNumber;
}
