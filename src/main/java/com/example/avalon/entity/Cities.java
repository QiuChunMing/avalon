package com.example.avalon.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Cities {
//    id: 1,
//    name: "上海",
//    abbr: "SH",
//    area_code: "021",
//    sort: 1,
//    latitude: 31.23037,
//    longitude: 121.473701,
//    is_map: true,
//    pinyin: "shanghai"
    @Id
    @GeneratedValue
    private int citiesId;
    private int id;
    private String name;
    private String abbr;
    @JsonProperty("area_code")
    private String code;
    private int sort;
    private double latitude;
    private double longitude;
    @JsonProperty("is_map")
    private boolean isMap;
    private String pinyin;
    @JsonProperty("is_hot_city")
    private boolean isHotCity = false;
}
