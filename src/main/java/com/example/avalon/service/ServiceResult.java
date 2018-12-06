package com.example.avalon.service;

import lombok.Data;

@Data
public class ServiceResult<T> {
    private boolean success;

    private String message;

    private T result;

    public ServiceResult(boolean success, String message, T result) {
        this.success = success;
        this.message = message;
        this.result = result;
    }

    public ServiceResult(boolean success) {
        this.success = success;
    }

    public ServiceResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public static <T> ServiceResult<T> success() {
        ServiceResult<T> serviceResult = new ServiceResult<T>(true);

        return serviceResult;
    }
    public static <T> ServiceResult<T> of(T result) {
        ServiceResult<T> serviceResult = new ServiceResult<>(true);
        serviceResult.setResult(result);
        return serviceResult;
    }
    public static <T> ServiceResult<T> notFound() {
        return new ServiceResult<>(false, Message.NOT_FOUND.getValue());
    }
    public static <T> ServiceResult<T> fail() {
        return new ServiceResult<>(false);
    }
    private enum Message {
        NOT_FOUND("Resource not found"),
        NOT_LOGIN("User not login");
        private String value;

        Message(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

}
