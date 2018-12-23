package com.example.avalon.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryDTO {

    /**
     * count : 0
     * image_url :
     * level : 1
     * name : 全部商家
     * sub_categories : []
     * ids : [207,220,260,233,239,244,248,252]
     * __v : 0
     */

    private int id;

    private int count;
    private String image_url = "";
    private int level;
    private String name;
    private List<CategoryDTO> sub_categories;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<CategoryDTO> getSub_categories() {
        return sub_categories;
    }

    public void setSub_categories(List<CategoryDTO> sub_categories) {
        this.sub_categories = sub_categories;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
