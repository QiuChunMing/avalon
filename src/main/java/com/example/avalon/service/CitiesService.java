package com.example.avalon.service;

import com.example.avalon.base.AddressSearch;
import com.example.avalon.base.response.GeocoderResponse;
import com.example.avalon.base.response.SearchPlaceResponse;
import com.example.avalon.base.utils.IPUtils;
import com.example.avalon.entity.Cities;
import com.example.avalon.repository.CitiesRepository;
import com.example.avalon.dto.PoisHashDTO;
import com.example.avalon.dto.PoisDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CitiesService {


    @Autowired
    private CitiesRepository citiesRepository;

    @Autowired
    private AddressSearch addressSearch;



    public ServiceResult<Cities> cityGuess() {
        return cityGuess(IPUtils.getIpAddress(getHttpServletRequest()));
    }

    public ServiceResult<Cities> cityGuess(String ip) {
        GeocoderResponse geocoder = addressSearch.geocoder(ip);

        if (geocoder != null && geocoder.getStatus() != 0) {
            String cityName = geocoder.getResult().getAd_info().getCity().replace("市", "");
            return getCityInfoByName(cityName);
        }
        return ServiceResult.fail();
    }

    public ServiceResult<List<Cities>> cityHot() {
        List<Cities> hotCity = citiesRepository.findByisHotCityTrue();
        if (hotCity == null) {
            return ServiceResult.fail();
        }
        return ServiceResult.of(hotCity);
    }


    private static HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }


    public ServiceResult<Cities> getCityInfoByName(String cityName) {
        Cities cityInfo = citiesRepository.findFirstByName(cityName);
        if (cityInfo == null) {
            return ServiceResult.fail();
        }
        return ServiceResult.of(cityInfo);
    }

    public ServiceResult<Cities> getCityInfoById(Integer id) {
        Cities cityInfo = citiesRepository.findFirstById(id);
        log.debug("city info {}", cityInfo);

        if (cityInfo == null) {
            return ServiceResult.fail();
        }
        return ServiceResult.of(cityInfo);
    }

    public ServiceResult<List<PoisDTO>> pois(Integer cityId, String keyword, String type) {
        if (cityId == null) {
            ServiceResult<Cities> result = this.cityGuess();
            if (result.isSuccess() && result.getResult() != null) {
                cityId = result.getResult().getId();
            } else {
                cityId = 553;
            }
        }
        ServiceResult<Cities> cityInfo = getCityInfoById(cityId);
        SearchPlaceResponse place;
        List<PoisDTO> poisDTOS;
        if (cityInfo.isSuccess()) {
            poisDTOS = new ArrayList<>();
            PoisDTO poisDTO = new PoisDTO();
            place = addressSearch.searchPlace(keyword, cityInfo.getResult().getName());
            if (place!=null) {
                for (SearchPlaceResponse.DataBean dataBean : place.getData()) {
                    poisDTO.setName(dataBean.getTitle());
                    poisDTO.setAddress(dataBean.getAddress());
                    poisDTO.setLatitude(dataBean.getLocation().getLat());
                    poisDTO.setLongitude(dataBean.getLocation().getLng());
                    poisDTO.setGeohash(poisDTO.getLatitude() + "," + poisDTO.getLongitude());
                    poisDTOS.add(poisDTO);
                }
            }

        } else {
            return ServiceResult.fail();
        }
        log.debug("{}", poisDTOS);
        return ServiceResult.of(poisDTOS);
    }

    public ServiceResult<PoisHashDTO> poishash(String lat, String lng) {
        GeocoderResponse geocoderResponse = addressSearch.getpois(lat,lng);
        if (geocoderResponse != null && geocoderResponse.getStatus() == 0) {
            PoisHashDTO poisHashDTO = new PoisHashDTO();
            poisHashDTO.setCity(geocoderResponse.getResult().getAd_info().getCity());
            poisHashDTO.setAddress(geocoderResponse.getResult().getAddress());
            poisHashDTO.setLatitude(String.valueOf(geocoderResponse.getResult().getLocation().getLat()));
            poisHashDTO.setLongitude(String.valueOf(geocoderResponse.getResult().getLocation().getLng()));
            poisHashDTO.setGeohash(poisHashDTO.getLatitude() + "," + poisHashDTO.getLongitude());
            poisHashDTO.setName(geocoderResponse.getResult().getFormatted_addresses().getRecommend());
            return ServiceResult.of(poisHashDTO);
        }
        return ServiceResult.fail();
    }


}