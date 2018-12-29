package com.example.avalon.service.address.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchPlaceResponse {


    /**
     * status : 0
     * message : query ok
     * count : 2289
     * request_id : 12008518120513e39f43ab334a845d34b79d7d104371
     * data : [{"id":"5451038037178123587","title":"广东财经大学","address":"广东省广州市海珠区赤沙路21号","tel":"020-84096844","category":"教育学校:大学","type":0,"location":{"lat":23.091867,"lng":113.354164},"ad_info":{"adcode":440105,"province":"广东省","city":"广州市","district":"海珠区"}},{"id":"12368825748964781798","title":"广东迎宾馆","address":"广东省广州市越秀区解放北路603号(火车站、越秀公园附近,东风中路路口)","tel":"020-83332950","category":"酒店宾馆:星级酒店","type":0,"location":{"lat":23.12831,"lng":113.26113},"ad_info":{"adcode":440104,"province":"广东省","city":"广州市","district":"越秀区"}},{"id":"18147230268462629697","title":"广东金融学院","address":"广东省广州市天河区龙洞迎福路527号","tel":"020-37216000","category":"教育学校:大学","type":0,"location":{"lat":23.20156,"lng":113.38063},"ad_info":{"adcode":440106,"province":"广东省","city":"广州市","district":"天河区"}},{"id":"1710799165593285621","title":"广东大厦","address":"广东省广州市越秀区东风中路309号","tel":" ","category":"酒店宾馆:星级酒店","type":0,"location":{"lat":23.13158,"lng":113.26722},"ad_info":{"adcode":440104,"province":"广东省","city":"广州市","district":"越秀区"}},{"id":"2629968273838898663","title":"广东培正学院","address":"广东省广州市花都区培正大道53号","tel":"020-86710904","category":"教育学校:大学","type":0,"location":{"lat":23.41066,"lng":113.09081},"ad_info":{"adcode":440114,"province":"广东省","city":"广州市","district":"花都区"}},{"id":"10584026822194437302","title":"广东番禺中学","address":"广东省广州市番禺区龙岐路501号","tel":"020-84737289","category":"教育学校:中学","type":0,"location":{"lat":22.90662,"lng":113.35903},"ad_info":{"adcode":440113,"province":"广东省","city":"广州市","district":"番禺区"}},{"id":"11966962098448759740","title":"广东电视台[公交站]","address":"夜56,高峰快线31,夜77,10,30,545,高峰快线2,夜14,夜15,夜25,夜4,夜41,夜5,482,夜89,125云台花园节假日班车,B10,225,550,189,125,191,219,220,63,256,节假日公交专线14,810,833,6,886","tel":" ","category":"基础设施:交通设施:公交车站","type":1,"location":{"lat":23.138039,"lng":113.282265},"ad_info":{"adcode":440104,"province":"广东省","city":"广州市","district":"越秀区"}},{"id":"13924619797621835123","title":"广东软件科学园","address":"广东省广州市天河区科学城彩频路11号","tel":"020-32068333","category":"房产小区:产业园区","type":0,"location":{"lat":23.163488,"lng":113.435899},"ad_info":{"adcode":440106,"province":"广东省","city":"广州市","district":"天河区"}},{"id":"11966272773935049390","title":"广东软件园[公交站]","address":"945,371A,320,夜81,388,高峰快线65,573,574,578,夜51,高峰快线32,B22,364,371,B4A,506,581,508,396,448","tel":" ","category":"基础设施:交通设施:公交车站","type":1,"location":{"lat":23.163791,"lng":113.438439},"ad_info":{"adcode":440106,"province":"广东省","city":"广州市","district":"天河区"}},{"id":"9242397599672007617","title":"广东仲元中学","address":"广东省广州市番禺区西涌大街2号","tel":"020-84822998","category":"教育学校:中学","type":0,"location":{"lat":22.93339,"lng":113.36063},"ad_info":{"adcode":440113,"province":"广东省","city":"广州市","district":"番禺区"}}]
     * region : {"title":"广州市"}
     */

    private int status;
    private String message;
    private int count;
    private String request_id;
    private RegionBean region;
    private List<DataBean> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public RegionBean getRegion() {
        return region;
    }

    public void setRegion(RegionBean region) {
        this.region = region;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RegionBean {
        /**
         * title : 广州市
         */

        private String title;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DataBean {
        /**
         * id : 5451038037178123587
         * title : 广东财经大学
         * address : 广东省广州市海珠区赤沙路21号
         * tel : 020-84096844
         * category : 教育学校:大学
         * type : 0
         * location : {"lat":23.091867,"lng":113.354164}
         * ad_info : {"adcode":440105,"province":"广东省","city":"广州市","district":"海珠区"}
         */

        private String id;
        private String title;
        private String address;
        private String tel;
        private String category;
        private int type;
        private LocationBean location;
        private AdInfoBean ad_info;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public LocationBean getLocation() {
            return location;
        }

        public void setLocation(LocationBean location) {
            this.location = location;
        }

        public AdInfoBean getAd_info() {
            return ad_info;
        }

        public void setAd_info(AdInfoBean ad_info) {
            this.ad_info = ad_info;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class LocationBean {
            /**
             * lat : 23.091867
             * lng : 113.354164
             */

            private double lat;
            private double lng;

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class AdInfoBean {
            /**
             * adcode : 440105
             * province : 广东省
             * city : 广州市
             * district : 海珠区
             */

            private int adcode;
            private String province;
            private String city;
            private String district;

            public int getAdcode() {
                return adcode;
            }

            public void setAdcode(int adcode) {
                this.adcode = adcode;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getDistrict() {
                return district;
            }

            public void setDistrict(String district) {
                this.district = district;
            }
        }
    }
}
