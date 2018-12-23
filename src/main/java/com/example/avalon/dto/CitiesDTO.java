package com.example.avalon.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
@Data
public class CitiesDTO {


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
    private String message;

}
