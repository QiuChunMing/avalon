package com.example.avalon.base.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@Data
@ToString
public class GuessPositionResponse {


    /**
     * status : 0
     * message : query ok
     * result : {"ip":"180.158.102.141","location":{"lat":31.18826,"lng":121.43687},"ad_info":{"nation":"中国","province":"上海市","city":"上海市","district":"徐汇区","adcode":310104}}
     */

    private int status;
    private String message;
    private ResultBean result;

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

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ResultBean {
        /**
         * ip : 180.158.102.141
         * location : {"lat":31.18826,"lng":121.43687}
         * ad_info : {"nation":"中国","province":"上海市","city":"上海市","district":"徐汇区","adcode":310104}
         */

        private String ip;
        private LocationBean location;
        private AdInfoBean ad_info;

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
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
             * lat : 31.18826
             * lng : 121.43687
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
             * nation : 中国
             * province : 上海市
             * city : 上海市
             * district : 徐汇区
             * adcode : 310104
             */

            private String nation;
            private String province;
            private String city;
            private String district;
            private int adcode;

            public String getNation() {
                return nation;
            }

            public void setNation(String nation) {
                this.nation = nation;
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

            public int getAdcode() {
                return adcode;
            }

            public void setAdcode(int adcode) {
                this.adcode = adcode;
            }
        }
    }
}
