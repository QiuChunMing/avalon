package com.example.avalon.web.admin.controller;

import com.example.avalon.service.statis.StatisService;
import com.example.avalon.web.APIResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@Slf4j
@RestController
public class StaticsController {

    @Autowired
    private StatisService statisService;
    /**
     * 获取data时间对应请求次数
     * @return
     */
    @GetMapping("/api/{date}/count")
    public APIResponse requestDateCount(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable LocalDate date) {
        return null;
    }

    /**
     * 获取所有请求次数
     * @return
     */
    @RequestMapping("api/count")
    public APIResponse requestAllCount() {
        return null;
    }

    @RequestMapping("/api/all")
    public Iterable requestAll() {
        return null;
    }

    /**
     * date时注册人数
     * @return
     */
    @RequestMapping("/user/{data}/count")
    public APIResponse userDateCount() {
        return null;
    }

    /**
     * date时订单数量
     * @return
     */
    @RequestMapping("/order/{date}/count")
    public APIResponse orderDateCount() {
        return null;
    }

    /**
     * 获取date天注册的管理员人数
     * @return
     */
    @RequestMapping("/admin/{date}/count")
    public APIResponse adminDateCount() {
        return null;
    }


}
