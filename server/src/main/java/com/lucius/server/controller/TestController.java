package com.lucius.server.controller;

import com.lucius.business.model.House;
import com.lucius.business.service.HouseService;
import com.lucius.common.support.controller.BaseControllerSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

/**
 * <br>
 *
 * @author Lucius
 * create by 2018/2/17
 * @Emial Lucius.li@ixiaoshuidi.com
 */
@RestController
@RequestMapping("/test")
public class TestController extends BaseControllerSupport {

    @Autowired
    HouseService houseService;

    @GetMapping("/get")
    public Page getMapping(){

        return houseService.findByModel(new House());
    }

    @GetMapping("/post")
    public String addHouse(){
        House house  = new House();
        house.setDoor("111111111111111111111111111");
        houseService.addHouse(house);
        return "success";
    }
}
