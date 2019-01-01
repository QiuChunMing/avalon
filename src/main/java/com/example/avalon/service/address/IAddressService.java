package com.example.avalon.service.address;

import com.example.avalon.service.ServiceResult;
import com.example.avalon.service.address.response.GeocoderResponse;
import com.example.avalon.service.address.response.GetDistanceResponse;
import com.example.avalon.service.address.response.GuessPositionResponse;
import com.example.avalon.service.address.response.SearchPlaceResponse;

import java.util.List;

public interface IAddressService {
    /**
     * 获取定位地址
     *
     * @param ip
     * @return
     */
    ServiceResult<GuessPositionResponse> guessPosition(String ip);

    /**
     * 搜索地址
     *
     * @param keyword
     * @param cityName
     * @return
     */
    ServiceResult<SearchPlaceResponse> searchPlace(String keyword, String cityName);

    ServiceResult<List<SimpleDistanceResponse>> getSimpleDistance(String from, String to);

    /**
     * 测量距离
     *
     * @param from
     * @param to
     */
    ServiceResult<GetDistanceResponse> getDistance(String from, String to);

    /**
     * 通过ip获取精确位置
     */
    ServiceResult<GeocoderResponse> geocoder(String ip);

    /**
     * 通过geohash获取精确位置
     */
    ServiceResult<GeocoderResponse> getPois(String lat, String lng);

    ServiceResult<List<SimpleAddressResponse>> AddressSuggest(String keyword, String cityName);
}
