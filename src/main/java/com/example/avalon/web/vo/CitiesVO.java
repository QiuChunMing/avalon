package com.example.avalon.web.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CitiesVO {

    /**
     * id : 1
     * name : 上海
     * abbr : SH
     * area_code : 021
     * sort : 1
     * latitude : 31.23037
     * longitude : 121.473701
     * is_map : true
     * pinyin : shanghai
     */

    private int id;
    private String name;
    private String abbr;
    private String area_code;
    private int sort;
    private double latitude;
    private double longitude;
    private boolean is_map;
    private String pinyin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public String getArea_code() {
        return area_code;
    }

    public void setArea_code(String area_code) {
        this.area_code = area_code;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public boolean isIs_map() {
        return is_map;
    }

    public void setIs_map(boolean is_map) {
        this.is_map = is_map;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }
}
