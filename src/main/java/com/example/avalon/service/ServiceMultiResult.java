package com.example.avalon.service;

import lombok.Data;

import java.util.List;

@Data
public class ServiceMultiResult<T> {
    private long total;
    private List<T> result;

    public ServiceMultiResult(long total, List<T> result) {
        this.total = total;
        this.result = result;
    }

}
