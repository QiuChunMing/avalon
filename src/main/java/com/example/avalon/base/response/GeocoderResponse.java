package com.example.avalon.base.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeocoderResponse {

    /**
     * status : 0
     * message : query ok
     * request_id : 92ef4714-f70e-11e8-9486-6c92bf53628b
     * result : {"location":{"lat":14,"lng":56},"address_component":{"nation":"Ocean","ad_level_1":"","ad_level_2":"","ad_level_3":"","street":"","locality":""},"ad_info":{"nation_code":"000","city_code":"","location":{"lat":14,"lng":56}},"address":"Ocean"}
     */

    private int status;
    private String message;
    private String request_id;
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

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
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
         * location : {"lat":14,"lng":56}
         * address_component : {"nation":"Ocean","ad_level_1":"","ad_level_2":"","ad_level_3":"","street":"","locality":""}
         * ad_info : {"nation_code":"000","city_code":"","location":{"lat":14,"lng":56}}
         * address : Ocean
         */

        private LocationBean location;
        private AddressComponentBean address_component;
        private AdInfoBean ad_info;
        private String address;

        public LocationBean getLocation() {
            return location;
        }

        public void setLocation(LocationBean location) {
            this.location = location;
        }

        public AddressComponentBean getAddress_component() {
            return address_component;
        }

        public void setAddress_component(AddressComponentBean address_component) {
            this.address_component = address_component;
        }

        public AdInfoBean getAd_info() {
            return ad_info;
        }

        public void setAd_info(AdInfoBean ad_info) {
            this.ad_info = ad_info;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class LocationBean {
            /**
             * lat : 14
             * lng : 56
             */

            private int lat;
            private int lng;

            public int getLat() {
                return lat;
            }

            public void setLat(int lat) {
                this.lat = lat;
            }

            public int getLng() {
                return lng;
            }

            public void setLng(int lng) {
                this.lng = lng;
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class AddressComponentBean {
            /**
             * nation : Ocean
             * ad_level_1 :
             * ad_level_2 :
             * ad_level_3 :
             * street :
             * locality :
             */

            private String nation;
            private String ad_level_1;
            private String ad_level_2;
            private String ad_level_3;
            private String street;
            private String locality;

            public String getNation() {
                return nation;
            }

            public void setNation(String nation) {
                this.nation = nation;
            }

            public String getAd_level_1() {
                return ad_level_1;
            }

            public void setAd_level_1(String ad_level_1) {
                this.ad_level_1 = ad_level_1;
            }

            public String getAd_level_2() {
                return ad_level_2;
            }

            public void setAd_level_2(String ad_level_2) {
                this.ad_level_2 = ad_level_2;
            }

            public String getAd_level_3() {
                return ad_level_3;
            }

            public void setAd_level_3(String ad_level_3) {
                this.ad_level_3 = ad_level_3;
            }

            public String getStreet() {
                return street;
            }

            public void setStreet(String street) {
                this.street = street;
            }

            public String getLocality() {
                return locality;
            }

            public void setLocality(String locality) {
                this.locality = locality;
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class AdInfoBean {
            /**
             * nation_code : 000
             * city_code :
             * location : {"lat":14,"lng":56}
             */

            private String nation_code;
            private String city_code;
            private LocationBeanX location;

            public String getNation_code() {
                return nation_code;
            }

            public void setNation_code(String nation_code) {
                this.nation_code = nation_code;
            }

            public String getCity_code() {
                return city_code;
            }

            public void setCity_code(String city_code) {
                this.city_code = city_code;
            }

            public LocationBeanX getLocation() {
                return location;
            }

            public void setLocation(LocationBeanX location) {
                this.location = location;
            }

            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class LocationBeanX {
                /**
                 * lat : 14
                 * lng : 56
                 */

                private int lat;
                private int lng;

                public int getLat() {
                    return lat;
                }

                public void setLat(int lat) {
                    this.lat = lat;
                }

                public int getLng() {
                    return lng;
                }

                public void setLng(int lng) {
                    this.lng = lng;
                }
            }
        }
    }
}
