package com.example.avalon.service.address;

import com.example.avalon.service.address.response.GeocoderResponse;
import com.example.avalon.service.address.response.GetDistanceResponse;
import com.example.avalon.service.address.response.GuessPositionResponse;
import com.example.avalon.service.address.response.SearchPlaceResponse;
import com.example.avalon.service.ServiceResult;

public interface IAddressService {
    /**
     * 获取定位地址
     *
     * @param ip
     * @return
     */
    public ServiceResult<GuessPositionResponse> guessPosition(String ip);

    /**
     * 搜索地址
     *
     * @param keyword
     * @param cityName
     * @return
     */
    public ServiceResult<SearchPlaceResponse> searchPlace(String keyword, String cityName);

    /**
     * 测量距离
     *
     * @param from
     * @param to
     */
    public ServiceResult<GetDistanceResponse> getDistance(String from, String to);

    /**
     * 通过ip获取精确位置
     */
    public ServiceResult<GeocoderResponse> geocoder(String ip);

    /**
     * 通过geohash获取精确位置
     */
    public ServiceResult<GeocoderResponse> getPois(String lat, String lng);
}
