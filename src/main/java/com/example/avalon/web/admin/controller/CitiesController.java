package com.example.avalon.web.admin.controller;

import com.example.avalon.entity.Cities;
import com.example.avalon.service.CitiesService;
import com.example.avalon.service.ServiceResult;
import com.example.avalon.dto.CitiesDTO;
import com.example.avalon.dto.PoisHashDTO;
import com.example.avalon.dto.PoisDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@Controller
@Slf4j
public class CitiesController {

    @Autowired
    private CitiesService citiesService;


    //获取城市列表
    public CitiesDTO cities(@RequestParam String type) {
        ServiceResult<Cities> result = null;
        switch (type) {
            case "guess":
                result = citiesService.cityGuess();
        }

        //TODO 从result提取有效地址信息
        log.debug("此次访问推测地址:{}", result.getResult());

        CitiesDTO vo = null;
        //查询详细信息
        if (result.isSuccess()) {
            ServiceResult<Cities> cityInfo = citiesService.getCityInfoByName(result.getResult().getName());
            vo = new CitiesDTO();
            if (cityInfo.getResult() != null) {
                BeanUtils.copyProperties(cityInfo.getResult(), vo);
            }
        } else {
            vo.setName("ERROR_DATA");
            vo.setMessage("查找数据失败");
        }
        return vo;
    }

    //获取所选城市信息
    public CitiesDTO citiesById(@PathVariable Integer id) {
        ServiceResult<Cities> result = citiesService.getCityInfoById(id);
        CitiesDTO vo = null;
        if (result.isSuccess()) {
            ServiceResult<Cities> cityInfo = citiesService.getCityInfoByName(result.getResult().getName());
            vo = new CitiesDTO();
            if (cityInfo.getResult() != null) {
                BeanUtils.copyProperties(cityInfo.getResult(), vo);
            }else {
                vo.setName("ERROR_DATA");
                vo.setMessage("查找数据失败");
            }

        }
        return vo;
    }

    //搜索地址
    public List<PoisDTO> pois(Integer cityId, String keyword, String type) {
        ServiceResult<List<PoisDTO>> pois = citiesService.pois(cityId, keyword, type);
        if (pois.isSuccess()) {
            return pois.getResult();
        }
        return Collections.EMPTY_LIST;
    }

    //根据经纬度详细定位
    public PoisHashDTO poishash(@PathVariable String geohash) {
        if (StringUtils.isEmpty(geohash)||!geohash.contains(",")) {
            return returnErrorParam();
        }
        String[] params = geohash.split(",");
        ServiceResult<PoisHashDTO> poishash = citiesService.poishash(params[0], params[1]);
        PoisHashDTO poisHashDTO;
        if (poishash.isSuccess()) {
            poisHashDTO = poishash.getResult();
        } else {
            return returnErrorParam();
        }
        return poisHashDTO;
    }

    public PoisHashDTO returnErrorParam() {
        PoisHashDTO poisHashDTO = new PoisHashDTO();
        poisHashDTO.setStatus(0);
        poisHashDTO.setType("ERROR_PARAM");
        poisHashDTO.setMessage("参数错误");
        return poisHashDTO;
    }

}
