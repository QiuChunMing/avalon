package com.example.avalon.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopDetail {

    /**
     * name : s
     * address : 广东省广州市海珠区红梅路61号2楼
     * description : ff
     * float_delivery_fee : 5
     * float_minimum_order_amount : 20
     * id : 3557
     * is_premium : true
     * is_new : true
     * latitude : 23.10239
     * longitude : 113.31413
     * location : [113.31413,23.10239]
     * opening_hours : ["06:00/06:15"]
     * phone : 88
     * promotion_info : dd
     * rating : 5.0
     * rating_count : 886
     * recent_order_num : 165
     * status : 1
     * image_path : 167c6991c9824298.png
     * category : 快餐便当/简餐
     * piecewise_agent_fee : {"tips":"配送费约¥5"}
     * activities : [{"icon_name":"减","name":"满减优惠","description":"满30减5，满60减8","icon_color":"f07373","id":1}]
     * supports : [{"description":"已加入\u201c外卖保\u201d计划，食品安全有保障","icon_color":"999999","icon_name":"保","id":7,"name":"外卖保"},{"description":"准时必达，超时秒赔","icon_color":"57A9FF","icon_name":"准","id":9,"name":"准时达"},{"description":"该商家支持开发票，请在下单时填写好发票抬头","icon_color":"999999","icon_name":"票","id":4,"name":"开发票"}]
     * license : {"business_license_image":"167c699215424299.png","catering_service_license_image":"167c699359724300.png"}
     * identification : {"company_name":"","identificate_agency":"","identificate_date":"","legal_person":"","licenses_date":"","licenses_number":"","licenses_scope":"","operation_period":"","registered_address":"","registered_number":""}
     * delivery_mode : {"color":"57A9FF","id":1,"is_solid":true,"text":"蜂鸟专送"}
     */

    private String name;
    private String address;
    private String description;
    private int float_delivery_fee;
    private int float_minimum_order_amount;
    private int id;
    private boolean is_premium;
    private boolean is_new;
    private double latitude;
    private double longitude;
    private int phone;
    private String promotion_info;
    private String rating;
    private int rating_count;
    private int recent_order_num;
    private int status;
    private String image_path;
    private String category;
    private PiecewiseAgentFeeBean piecewise_agent_fee;
    private LicenseBean license;
    private IdentificationBean identification;
    private DeliveryModeBean delivery_mode;
    private List<Double> location;
    private List<String> opening_hours;
    private List<ActivitiesBean> activities;
    private List<SupportsBean> supports;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFloat_delivery_fee() {
        return float_delivery_fee;
    }

    public void setFloat_delivery_fee(int float_delivery_fee) {
        this.float_delivery_fee = float_delivery_fee;
    }

    public int getFloat_minimum_order_amount() {
        return float_minimum_order_amount;
    }

    public void setFloat_minimum_order_amount(int float_minimum_order_amount) {
        this.float_minimum_order_amount = float_minimum_order_amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIs_premium() {
        return is_premium;
    }

    public void setIs_premium(boolean is_premium) {
        this.is_premium = is_premium;
    }

    public boolean isIs_new() {
        return is_new;
    }

    public void setIs_new(boolean is_new) {
        this.is_new = is_new;
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getPromotion_info() {
        return promotion_info;
    }

    public void setPromotion_info(String promotion_info) {
        this.promotion_info = promotion_info;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getRating_count() {
        return rating_count;
    }

    public void setRating_count(int rating_count) {
        this.rating_count = rating_count;
    }

    public int getRecent_order_num() {
        return recent_order_num;
    }

    public void setRecent_order_num(int recent_order_num) {
        this.recent_order_num = recent_order_num;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public PiecewiseAgentFeeBean getPiecewise_agent_fee() {
        return piecewise_agent_fee;
    }

    public void setPiecewise_agent_fee(PiecewiseAgentFeeBean piecewise_agent_fee) {
        this.piecewise_agent_fee = piecewise_agent_fee;
    }

    public LicenseBean getLicense() {
        return license;
    }

    public void setLicense(LicenseBean license) {
        this.license = license;
    }

    public IdentificationBean getIdentification() {
        return identification;
    }

    public void setIdentification(IdentificationBean identification) {
        this.identification = identification;
    }

    public DeliveryModeBean getDelivery_mode() {
        return delivery_mode;
    }

    public void setDelivery_mode(DeliveryModeBean delivery_mode) {
        this.delivery_mode = delivery_mode;
    }

    public List<Double> getLocation() {
        return location;
    }

    public void setLocation(List<Double> location) {
        this.location = location;
    }

    public List<String> getOpening_hours() {
        return opening_hours;
    }

    public void setOpening_hours(List<String> opening_hours) {
        this.opening_hours = opening_hours;
    }

    public List<ActivitiesBean> getActivities() {
        return activities;
    }

    public void setActivities(List<ActivitiesBean> activities) {
        this.activities = activities;
    }

    public List<SupportsBean> getSupports() {
        return supports;
    }

    public void setSupports(List<SupportsBean> supports) {
        this.supports = supports;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PiecewiseAgentFeeBean {
        /**
         * tips : 配送费约¥5
         */

        private String tips;

        public String getTips() {
            return tips;
        }

        public void setTips(String tips) {
            this.tips = tips;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class LicenseBean {
        /**
         * business_license_image : 167c699215424299.png
         * catering_service_license_image : 167c699359724300.png
         */

        private String business_license_image;
        private String catering_service_license_image;

        public String getBusiness_license_image() {
            return business_license_image;
        }

        public void setBusiness_license_image(String business_license_image) {
            this.business_license_image = business_license_image;
        }

        public String getCatering_service_license_image() {
            return catering_service_license_image;
        }

        public void setCatering_service_license_image(String catering_service_license_image) {
            this.catering_service_license_image = catering_service_license_image;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class IdentificationBean {
        /**
         * company_name :
         * identificate_agency :
         * identificate_date :
         * legal_person :
         * licenses_date :
         * licenses_number :
         * licenses_scope :
         * operation_period :
         * registered_address :
         * registered_number :
         */

        private String company_name;
        private String identificate_agency;
        private String identificate_date;
        private String legal_person;
        private String licenses_date;
        private String licenses_number;
        private String licenses_scope;
        private String operation_period;
        private String registered_address;
        private String registered_number;

        public String getCompany_name() {
            return company_name;
        }

        public void setCompany_name(String company_name) {
            this.company_name = company_name;
        }

        public String getIdentificate_agency() {
            return identificate_agency;
        }

        public void setIdentificate_agency(String identificate_agency) {
            this.identificate_agency = identificate_agency;
        }

        public String getIdentificate_date() {
            return identificate_date;
        }

        public void setIdentificate_date(String identificate_date) {
            this.identificate_date = identificate_date;
        }

        public String getLegal_person() {
            return legal_person;
        }

        public void setLegal_person(String legal_person) {
            this.legal_person = legal_person;
        }

        public String getLicenses_date() {
            return licenses_date;
        }

        public void setLicenses_date(String licenses_date) {
            this.licenses_date = licenses_date;
        }

        public String getLicenses_number() {
            return licenses_number;
        }

        public void setLicenses_number(String licenses_number) {
            this.licenses_number = licenses_number;
        }

        public String getLicenses_scope() {
            return licenses_scope;
        }

        public void setLicenses_scope(String licenses_scope) {
            this.licenses_scope = licenses_scope;
        }

        public String getOperation_period() {
            return operation_period;
        }

        public void setOperation_period(String operation_period) {
            this.operation_period = operation_period;
        }

        public String getRegistered_address() {
            return registered_address;
        }

        public void setRegistered_address(String registered_address) {
            this.registered_address = registered_address;
        }

        public String getRegistered_number() {
            return registered_number;
        }

        public void setRegistered_number(String registered_number) {
            this.registered_number = registered_number;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DeliveryModeBean {
        /**
         * color : 57A9FF
         * id : 1
         * is_solid : true
         * text : 蜂鸟专送
         */

        private String color;
        private int id;
        private boolean is_solid;
        private String text;

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean isIs_solid() {
            return is_solid;
        }

        public void setIs_solid(boolean is_solid) {
            this.is_solid = is_solid;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ActivitiesBean {
        /**
         * icon_name : 减
         * name : 满减优惠
         * description : 满30减5，满60减8
         * icon_color : f07373
         * id : 1
         */

        private String icon_name;
        private String name;
        private String description;
        private String icon_color;
        private int id;

        public String getIcon_name() {
            return icon_name;
        }

        public void setIcon_name(String icon_name) {
            this.icon_name = icon_name;
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

        public String getIcon_color() {
            return icon_color;
        }

        public void setIcon_color(String icon_color) {
            this.icon_color = icon_color;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SupportsBean {
        /**
         * description : 已加入“外卖保”计划，食品安全有保障
         * icon_color : 999999
         * icon_name : 保
         * id : 7
         * name : 外卖保
         */

        private String description;
        private String icon_color;
        private String icon_name;
        private int id;
        private String name;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getIcon_color() {
            return icon_color;
        }

        public void setIcon_color(String icon_color) {
            this.icon_color = icon_color;
        }

        public String getIcon_name() {
            return icon_name;
        }

        public void setIcon_name(String icon_name) {
            this.icon_name = icon_name;
        }

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
    }
}
