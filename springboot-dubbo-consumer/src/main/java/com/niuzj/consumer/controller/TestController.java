package com.niuzj.consumer.controller;

import com.alibaba.dubbo.rpc.service.GenericService;
import com.niuzj.user.UserService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

//    @Resource(name = "userService")
//    private UserService userService;

//    @Resource(name = "userService2")
//    private UserService userService2;

    @Autowired
    @Qualifier("userService")
    private GenericService genericService1;

//    @RequestMapping("/getUsername")
//    public String getUsername(){
//        return userService.getUsername();
//    }

//    @RequestMapping("/getUsername2")
//    public String getUsername2(){
//        return userService2.getUsername();
//    }

    /**
     * 测试泛化调用
     */
    @RequestMapping("/getUsername3")
    public String getUsername3() {
        Object result = genericService1.$invoke("getUsername", null, null);
        //实体类传参实例
//        Map<String, Object> map = new HashMap<>();
//        map.put("name", "nzj");
//        map.put("age", 22);
//        Object obj = genericService1.$invoke("updateUser", new String[]{"java.util.Map"}, new Object[]{map});
        return result.toString();
    }

}
