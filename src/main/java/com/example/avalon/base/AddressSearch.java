package com.example.avalon.base;

import com.example.avalon.base.response.GeocoderResponse;
import com.example.avalon.base.response.GetDistanceResponse;
import com.example.avalon.base.response.GuessPositionResponse;
import com.example.avalon.base.response.SearchPlaceResponse;

public interface AddressSearch {
    /**
     * 获取定位地址
     *
     * @param ip
     * @return
     */
    public GuessPositionResponse guessPosition(String ip);

    /**
     * 搜索地址
     *
     * @param keyword
     * @param cityName
     * @return
     */
    public SearchPlaceResponse searchPlace(String keyword, String cityName);

    /**
     * 测量距离
     *
     * @param from
     * @param to
     */
    public GetDistanceResponse getDistance(String from, String to);

    /**
     * 通过ip获取精确位置
     */
    public GeocoderResponse geocoder(String ip);

    /**
     * 通过geohash获取精确位置
     */
    public GeocoderResponse getpois(String lat, String lng);
}
