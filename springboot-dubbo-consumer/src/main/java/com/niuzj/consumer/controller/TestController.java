package com.niuzj.consumer.controller;

import com.niuzj.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUsername")
    @ResponseBody
    public String getUsername(){
        return userService.getUsername();
    }
}
