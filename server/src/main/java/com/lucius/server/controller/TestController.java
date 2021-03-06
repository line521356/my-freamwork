package com.lucius.server.controller;

import com.lucius.business.condition.HouseCondition;
//import com.lucius.business.model.hardware.House;
import com.lucius.business.service.AmmeterService;
//import com.lucius.business.service.HouseService;
import com.lucius.common.support.controller.BaseControllerSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
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
@Api("房源")
public class TestController extends BaseControllerSupport {

//    @Autowired
//    HouseService houseService;

    @Autowired
    AmmeterService ammeterService;

//    @GetMapping(value = "/list")
//    @ApiOperation(value="获取房源list")
//    @ApiImplicitParam(name="house",value="house实体",required = true, dataType = "House")
//    public ResponseEntity<Page> list(HouseCondition houseCondition,Pageable pageable){
//        return ResponseEntity.ok(houseService.findByModel(houseCondition,pageable));
//    }

//    @GetMapping(value = "/info/{id}")
//    public ResponseEntity<House> info(@PathVariable Long id){
//        return ResponseEntity.ok(houseService.findById(id));
//    }

//    @PostMapping("/post")
//    public String addHouse(){
//        House house  = new House();
//        house.setDoor("111111111111111111111111111");
//        houseService.addHouse(house);
//        return "success";
//    }

    @GetMapping("/posta")
    public Page getAmmeter(){
        Page page = ammeterService.getAmmeter(null);
        return page;
    }
}
