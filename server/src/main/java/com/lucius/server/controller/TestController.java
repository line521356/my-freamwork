package com.lucius.server.controller;

import com.lucius.common.controller.BaseController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <br>
 *
 * @author Lucius
 * create by 2018/2/17
 * @Emial Lucius.li@ixiaoshuidi.com
 */
@RestController
@RequestMapping("/test")
public class TestController extends BaseController {

    @GetMapping("/get")
    public String getMapping(){
        System.out.println("test*****************************");
        return "success";
    }
}
