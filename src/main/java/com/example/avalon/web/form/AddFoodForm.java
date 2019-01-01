package com.example.avalon.web.form;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddFoodForm {

    /**
     * name : xvxv
     * description : vx
     * imagePath : 167ff2fb5e97.png
     * activity : xvx
     * attributes : ["新","招牌"]
     * specs : [{"specs":"默认","packingFee":0,"price":20}]
     * restaurantId : 1
     */

    private Integer category_id;
    private String name;
    private String description;
    private String imagePath;
    private String activity;
    private int restaurantId;
    private List<String> attributes;
    private List<SpecsBean> specs;

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public List<String> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<String> attributes) {
        this.attributes = attributes;
    }

    public List<SpecsBean> getSpecs() {
        return specs;
    }

    public void setSpecs(List<SpecsBean> specs) {
        this.specs = specs;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SpecsBean {
        /**
         * specs : 默认
         * packingFee : 0
         * price : 20
         */

        private String specs;
        private int packingFee;
        private int price;

        public String getSpecs() {
            return specs;
        }

        public void setSpecs(String specs) {
            this.specs = specs;
        }

        public int getPackingFee() {
            return packingFee;
        }

        public void setPackingFee(int packingFee) {
            this.packingFee = packingFee;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }
}
