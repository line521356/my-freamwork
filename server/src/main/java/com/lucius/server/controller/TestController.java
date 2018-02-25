package com.lucius.server.controller;

import com.lucius.common.support.controller.BaseControllerSupport;
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
public class TestController extends BaseControllerSupport {

    @GetMapping("/get")
    public String getMapping(){
        System.out.println("test*****************************");
        return "success";
    }
}
