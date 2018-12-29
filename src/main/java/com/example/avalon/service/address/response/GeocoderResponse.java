package com.example.avalon.service.address.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class GeocoderResponse {


    /**
     * status : 0
     * message : query ok
     * request_id : 5874809a-ffab-11e8-b2ec-6c92bf53528b
     * result : {"location":{"lat":23.12908,"lng":113.264359},"address":"广东省广州市越秀区府前路1号","formatted_addresses":{"recommend":"越秀区广州市政府(府前路北)","rough":"越秀区广州市政府(府前路北)"},"address_component":{"nation":"中国","province":"广东省","city":"广州市","district":"越秀区","street":"府前路","street_number":"府前路1号"},"ad_info":{"nation_code":"156","adcode":"440104","city_code":"156440100","name":"中国,广东省,广州市,越秀区","location":{"lat":23.12908,"lng":113.264359},"nation":"中国","province":"广东省","city":"广州市","district":"越秀区"},"address_reference":{"crossroad":{"id":"1319223","title":"越华路/吉祥路(路口)","location":{"lat":23.129101,"lng":113.265472},"_distance":108.6,"_dir_desc":"西"},"town":{"id":"440104003","title":"北京街道","location":{"lat":23.12908,"lng":113.264359},"_distance":0,"_dir_desc":"内"},"street_number":{"id":"7566497706870191487","title":"府前路1号","location":{"lat":23.12908,"lng":113.264359},"_distance":0,"_dir_desc":""},"street":{"id":"7208563079563035845","title":"府前路","location":{"lat":23.128731,"lng":113.264359},"_distance":33.4,"_dir_desc":"北"},"landmark_l2":{"id":"7566497706870191487","title":"广州市政府","location":{"lat":23.12908,"lng":113.264359},"_distance":0,"_dir_desc":"内"}}}
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
         * location : {"lat":23.12908,"lng":113.264359}
         * address : 广东省广州市越秀区府前路1号
         * formatted_addresses : {"recommend":"越秀区广州市政府(府前路北)","rough":"越秀区广州市政府(府前路北)"}
         * address_component : {"nation":"中国","province":"广东省","city":"广州市","district":"越秀区","street":"府前路","street_number":"府前路1号"}
         * ad_info : {"nation_code":"156","adcode":"440104","city_code":"156440100","name":"中国,广东省,广州市,越秀区","location":{"lat":23.12908,"lng":113.264359},"nation":"中国","province":"广东省","city":"广州市","district":"越秀区"}
         * address_reference : {"crossroad":{"id":"1319223","title":"越华路/吉祥路(路口)","location":{"lat":23.129101,"lng":113.265472},"_distance":108.6,"_dir_desc":"西"},"town":{"id":"440104003","title":"北京街道","location":{"lat":23.12908,"lng":113.264359},"_distance":0,"_dir_desc":"内"},"street_number":{"id":"7566497706870191487","title":"府前路1号","location":{"lat":23.12908,"lng":113.264359},"_distance":0,"_dir_desc":""},"street":{"id":"7208563079563035845","title":"府前路","location":{"lat":23.128731,"lng":113.264359},"_distance":33.4,"_dir_desc":"北"},"landmark_l2":{"id":"7566497706870191487","title":"广州市政府","location":{"lat":23.12908,"lng":113.264359},"_distance":0,"_dir_desc":"内"}}
         */

        private LocationBean location;
        private String address;
        private FormattedAddressesBean formatted_addresses;
        private AddressComponentBean address_component;
        private AdInfoBean ad_info;
        private AddressReferenceBean address_reference;

        public LocationBean getLocation() {
            return location;
        }

        public void setLocation(LocationBean location) {
            this.location = location;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public FormattedAddressesBean getFormatted_addresses() {
            return formatted_addresses;
        }

        public void setFormatted_addresses(FormattedAddressesBean formatted_addresses) {
            this.formatted_addresses = formatted_addresses;
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

        public AddressReferenceBean getAddress_reference() {
            return address_reference;
        }

        public void setAddress_reference(AddressReferenceBean address_reference) {
            this.address_reference = address_reference;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class LocationBean {
            /**
             * lat : 23.12908
             * lng : 113.264359
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
        public static class FormattedAddressesBean {
            /**
             * recommend : 越秀区广州市政府(府前路北)
             * rough : 越秀区广州市政府(府前路北)
             */

            private String recommend;
            private String rough;

            public String getRecommend() {
                return recommend;
            }

            public void setRecommend(String recommend) {
                this.recommend = recommend;
            }

            public String getRough() {
                return rough;
            }

            public void setRough(String rough) {
                this.rough = rough;
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class AddressComponentBean {
            /**
             * nation : 中国
             * province : 广东省
             * city : 广州市
             * district : 越秀区
             * street : 府前路
             * street_number : 府前路1号
             */

            private String nation;
            private String province;
            private String city;
            private String district;
            private String street;
            private String street_number;

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

            public String getStreet() {
                return street;
            }

            public void setStreet(String street) {
                this.street = street;
            }

            public String getStreet_number() {
                return street_number;
            }

            public void setStreet_number(String street_number) {
                this.street_number = street_number;
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class AdInfoBean {
            /**
             * nation_code : 156
             * adcode : 440104
             * city_code : 156440100
             * name : 中国,广东省,广州市,越秀区
             * location : {"lat":23.12908,"lng":113.264359}
             * nation : 中国
             * province : 广东省
             * city : 广州市
             * district : 越秀区
             */

            private String nation_code;
            private String adcode;
            private String city_code;
            private String name;
            private LocationBeanX location;
            private String nation;
            private String province;
            private String city;
            private String district;

            public String getNation_code() {
                return nation_code;
            }

            public void setNation_code(String nation_code) {
                this.nation_code = nation_code;
            }

            public String getAdcode() {
                return adcode;
            }

            public void setAdcode(String adcode) {
                this.adcode = adcode;
            }

            public String getCity_code() {
                return city_code;
            }

            public void setCity_code(String city_code) {
                this.city_code = city_code;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public LocationBeanX getLocation() {
                return location;
            }

            public void setLocation(LocationBeanX location) {
                this.location = location;
            }

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

            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class LocationBeanX {
                /**
                 * lat : 23.12908
                 * lng : 113.264359
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
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class AddressReferenceBean {
            /**
             * crossroad : {"id":"1319223","title":"越华路/吉祥路(路口)","location":{"lat":23.129101,"lng":113.265472},"_distance":108.6,"_dir_desc":"西"}
             * town : {"id":"440104003","title":"北京街道","location":{"lat":23.12908,"lng":113.264359},"_distance":0,"_dir_desc":"内"}
             * street_number : {"id":"7566497706870191487","title":"府前路1号","location":{"lat":23.12908,"lng":113.264359},"_distance":0,"_dir_desc":""}
             * street : {"id":"7208563079563035845","title":"府前路","location":{"lat":23.128731,"lng":113.264359},"_distance":33.4,"_dir_desc":"北"}
             * landmark_l2 : {"id":"7566497706870191487","title":"广州市政府","location":{"lat":23.12908,"lng":113.264359},"_distance":0,"_dir_desc":"内"}
             */

            private CrossroadBean crossroad;
            private TownBean town;
            private StreetNumberBean street_number;
            private StreetBean street;
            private LandmarkL2Bean landmark_l2;

            public CrossroadBean getCrossroad() {
                return crossroad;
            }

            public void setCrossroad(CrossroadBean crossroad) {
                this.crossroad = crossroad;
            }

            public TownBean getTown() {
                return town;
            }

            public void setTown(TownBean town) {
                this.town = town;
            }

            public StreetNumberBean getStreet_number() {
                return street_number;
            }

            public void setStreet_number(StreetNumberBean street_number) {
                this.street_number = street_number;
            }

            public StreetBean getStreet() {
                return street;
            }

            public void setStreet(StreetBean street) {
                this.street = street;
            }

            public LandmarkL2Bean getLandmark_l2() {
                return landmark_l2;
            }

            public void setLandmark_l2(LandmarkL2Bean landmark_l2) {
                this.landmark_l2 = landmark_l2;
            }

            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class CrossroadBean {
                /**
                 * id : 1319223
                 * title : 越华路/吉祥路(路口)
                 * location : {"lat":23.129101,"lng":113.265472}
                 * _distance : 108.6
                 * _dir_desc : 西
                 */

                private String id;
                private String title;
                private LocationBeanXX location;
                private double _distance;
                private String _dir_desc;

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

                public LocationBeanXX getLocation() {
                    return location;
                }

                public void setLocation(LocationBeanXX location) {
                    this.location = location;
                }

                public double get_distance() {
                    return _distance;
                }

                public void set_distance(double _distance) {
                    this._distance = _distance;
                }

                public String get_dir_desc() {
                    return _dir_desc;
                }

                public void set_dir_desc(String _dir_desc) {
                    this._dir_desc = _dir_desc;
                }

                @JsonIgnoreProperties(ignoreUnknown = true)
                public static class LocationBeanXX {
                    /**
                     * lat : 23.129101
                     * lng : 113.265472
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
            }

            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class TownBean {
                /**
                 * id : 440104003
                 * title : 北京街道
                 * location : {"lat":23.12908,"lng":113.264359}
                 * _distance : 0
                 * _dir_desc : 内
                 */

                private String id;
                private String title;
                private LocationBeanXXX location;
                private int _distance;
                private String _dir_desc;

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

                public LocationBeanXXX getLocation() {
                    return location;
                }

                public void setLocation(LocationBeanXXX location) {
                    this.location = location;
                }

                public int get_distance() {
                    return _distance;
                }

                public void set_distance(int _distance) {
                    this._distance = _distance;
                }

                public String get_dir_desc() {
                    return _dir_desc;
                }

                public void set_dir_desc(String _dir_desc) {
                    this._dir_desc = _dir_desc;
                }

                @JsonIgnoreProperties(ignoreUnknown = true)
                public static class LocationBeanXXX {
                    /**
                     * lat : 23.12908
                     * lng : 113.264359
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
            }

            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class StreetNumberBean {
                /**
                 * id : 7566497706870191487
                 * title : 府前路1号
                 * location : {"lat":23.12908,"lng":113.264359}
                 * _distance : 0
                 * _dir_desc :
                 */

                private String id;
                private String title;
                private LocationBeanXXXX location;
                private int _distance;
                private String _dir_desc;

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

                public LocationBeanXXXX getLocation() {
                    return location;
                }

                public void setLocation(LocationBeanXXXX location) {
                    this.location = location;
                }

                public int get_distance() {
                    return _distance;
                }

                public void set_distance(int _distance) {
                    this._distance = _distance;
                }

                public String get_dir_desc() {
                    return _dir_desc;
                }

                public void set_dir_desc(String _dir_desc) {
                    this._dir_desc = _dir_desc;
                }

                @JsonIgnoreProperties(ignoreUnknown = true)
                public static class LocationBeanXXXX {
                    /**
                     * lat : 23.12908
                     * lng : 113.264359
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
            }

            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class StreetBean {
                /**
                 * id : 7208563079563035845
                 * title : 府前路
                 * location : {"lat":23.128731,"lng":113.264359}
                 * _distance : 33.4
                 * _dir_desc : 北
                 */

                private String id;
                private String title;
                private LocationBeanXXXXX location;
                private double _distance;
                private String _dir_desc;

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

                public LocationBeanXXXXX getLocation() {
                    return location;
                }

                public void setLocation(LocationBeanXXXXX location) {
                    this.location = location;
                }

                public double get_distance() {
                    return _distance;
                }

                public void set_distance(double _distance) {
                    this._distance = _distance;
                }

                public String get_dir_desc() {
                    return _dir_desc;
                }

                public void set_dir_desc(String _dir_desc) {
                    this._dir_desc = _dir_desc;
                }

                @JsonIgnoreProperties(ignoreUnknown = true)
                public static class LocationBeanXXXXX {
                    /**
                     * lat : 23.128731
                     * lng : 113.264359
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
            }

            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class LandmarkL2Bean {
                /**
                 * id : 7566497706870191487
                 * title : 广州市政府
                 * location : {"lat":23.12908,"lng":113.264359}
                 * _distance : 0
                 * _dir_desc : 内
                 */

                private String id;
                private String title;
                private LocationBeanXXXXXX location;
                private int _distance;
                private String _dir_desc;

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

                public LocationBeanXXXXXX getLocation() {
                    return location;
                }

                public void setLocation(LocationBeanXXXXXX location) {
                    this.location = location;
                }

                public int get_distance() {
                    return _distance;
                }

                public void set_distance(int _distance) {
                    this._distance = _distance;
                }

                public String get_dir_desc() {
                    return _dir_desc;
                }

                public void set_dir_desc(String _dir_desc) {
                    this._dir_desc = _dir_desc;
                }

                @JsonIgnoreProperties(ignoreUnknown = true)
                public static class LocationBeanXXXXXX {
                    /**
                     * lat : 23.12908
                     * lng : 113.264359
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
            }
        }
    }
}
