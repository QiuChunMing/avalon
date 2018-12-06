package com.example.avalon.web.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Collections;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryVO {
    /**
     * count : 0
     * id : 220
     * image_url : 655ac1bfd1e818013a9f099e964f1e9djpeg
     * level : 1
     * name : 特色菜系
     * sub_categories : [{"count":0,"id":220,"image_url":"ef32dabbcd88fbed5a336383e74c733dpng","level":1,"name":"全部特色菜系","_id":"5c064295888d4a47b486f466"},{"count":0,"id":221,"image_url":"43b0e4694f8ebc393cce6723d5df5222png","level":2,"name":"川湘菜","_id":"5c064295888d4a47b486f465"},{"count":0,"id":263,"image_url":"94ac841e2c3e27f8eeeaa917574ed574png","level":2,"name":"其他菜系","_id":"5c064295888d4a47b486f464"},{"count":0,"id":225,"image_url":"2d098842683548f9626cf0a8c879257dpng","level":2,"name":"江浙菜","_id":"5c064295888d4a47b486f463"},{"count":0,"id":222,"image_url":"e320bf1ab9762cb1faad27d79f51219cpng","level":2,"name":"粤菜","_id":"5c064295888d4a47b486f462"},{"count":0,"id":232,"image_url":"a33f1ec0044ddd4d282fbc8b1f0a946fpng","level":2,"name":"海鲜","_id":"5c064295888d4a47b486f461"},{"count":0,"id":231,"image_url":"c03d81f550eb849ed2d4d0290ced9099png","level":2,"name":"火锅烤鱼","_id":"5c064295888d4a47b486f460"},{"count":0,"id":223,"image_url":"aa4de1e9b54170cf495d8052407658c5png","level":2,"name":"东北菜","_id":"5c064295888d4a47b486f45f"},{"count":0,"id":226,"image_url":"741d15270496d7699dd2e7804fccc7a1png","level":2,"name":"西北菜","_id":"5c064295888d4a47b486f45e"},{"count":0,"id":224,"image_url":"54dabf93116f4a336fcc91431be43828png","level":2,"name":"云南菜","_id":"5c064295888d4a47b486f45d"},{"count":0,"id":228,"image_url":"a7e6d9cf1993fa4fe0bd02d74d40c9c2png","level":2,"name":"新疆菜","_id":"5c064295888d4a47b486f45c"},{"count":0,"id":227,"image_url":"e19bf59188a157dfc372b3d254fc986dpng","level":2,"name":"鲁菜","_id":"5c064295888d4a47b486f45b"}]
     * ids : [220]
     * __v : 0
     */

    private int count = 0;
    private int id;
    private String image_url;
    private int level = 1;
    private String name;
    private int __v = 0;
    private List<CategoryVO> sub_categories = Collections.emptyList();
    private List<Integer> ids;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }

    public List<CategoryVO> getSub_categories() {
        return sub_categories;
    }

    public void setSub_categories(List<CategoryVO> sub_categories) {
        this.sub_categories = sub_categories;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
