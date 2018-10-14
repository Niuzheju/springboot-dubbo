package com.niuzj.consumer.controller;

import com.niuzj.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class TestController {

    @Resource(name = "userService")
    private UserService userService;

    @Resource(name = "userService2")
    private UserService userService2;

    @RequestMapping("/getUsername")
    public String getUsername(){
        return userService.getUsername();
    }

    @RequestMapping("/getUsername2")
    public String getUsername2(){
        return userService2.getUsername();
    }

}
