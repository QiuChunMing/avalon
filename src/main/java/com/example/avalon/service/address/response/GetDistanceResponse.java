package com.example.avalon.service.address.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetDistanceResponse {

    /**
     * status : 0
     * result : [{"distance":{"text":"202.6公里","value":202635},"duration":{"text":"2.1小时","value":7598}}]
     * message : 成功
     */

    private int status;
    private String message;
    private List<ResultBean> result;

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ResultBean {
        /**
         * distance : {"text":"202.6公里","value":202635}
         * duration : {"text":"2.1小时","value":7598}
         */

        private DistanceBean distance;
        private DurationBean duration;

        public DistanceBean getDistance() {
            return distance;
        }

        public void setDistance(DistanceBean distance) {
            this.distance = distance;
        }

        public DurationBean getDuration() {
            return duration;
        }

        public void setDuration(DurationBean duration) {
            this.duration = duration;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class DistanceBean {
            /**
             * text : 202.6公里
             * value : 202635
             */

            private String text;
            private int value;

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class DurationBean {
            /**
             * text : 2.1小时
             * value : 7598
             */

            private String text;
            private int value;

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }
        }
    }
}
