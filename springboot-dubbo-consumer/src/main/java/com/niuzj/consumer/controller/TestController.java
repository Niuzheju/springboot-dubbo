package com.niuzj.consumer.controller;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.niuzj.model.User;
import com.niuzj.user.IGroupMergedService;
import com.niuzj.user.IOrderService;
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
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/test")
public class TestController {

    @Resource(name = "userService")
    private UserService userService;

    @Resource(name = "userService2")
    private UserService userService2;

    @Autowired
    private IOrderService orderService;

//    @Autowired
//    @Qualifier("userService")
//    private GenericService genericService1;

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
     * xml:generic-invoke.xml
     */
//    @RequestMapping("/getUsername3")
//    public String getUsername3() {
//        Object result = genericService1.$invoke("getUsername", null, null);
    //实体类传参实例
//        Map<String, Object> map = new HashMap<>();
//        map.put("name", "nzj");
//        map.put("age", 22);
//        Object obj = genericService1.$invoke("updateUser", new String[]{"java.util.Map"}, new Object[]{map});
//        return result.toString();
//    }

    /**
     * 测试参数回调
     * xml:normal.xml
     */
    @RequestMapping("/getUsername4")
    public String getUsername4() {
        return userService.getUsername(() -> "xxx");
    }

    /**
     * 异步调用1
     * xml:asnc-invoke.xml
     * 调用多个接口时需要在调用接口后获取Future类,以便后面获取接口的返回结果
     */
    @RequestMapping("/getUsername5")
    public String getUsername5() {
        String username1 = null;
        String username2 = null;
        try {
            //使用异步调用后此方法立即返回null
            username1 = userService.getUsername();
            System.out.println("username1 now is " + username1);
            //通过Future获取接口的返回结果
            Future<Object> future = RpcContext.getContext().getFuture();
            //get方法阻塞, 直到获取接口返回结果后才返回, 也可设置阻塞指定时间后返回
            username2 = userService.getUsername(() -> "zyq");
            System.out.println("username2 now is " + username2);
            Future<Object> future1 = RpcContext.getContext().getFuture();
            username1 = (String) future.get();
            username2 = (String) future1.get();
//            future.get(1000, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return username1 + username2;
    }

    /**
     * 异步调用2
     */
    @RequestMapping("/getUsername6")
    public String getUsername6() {
        String username1 = "";
        String username2 = "";
        try {
            Future<Object> future = RpcContext.getContext().asyncCall(() -> userService.getUsername());
            Future<Object> future1 = RpcContext.getContext().asyncCall(() -> userService.getUsername(() -> "zyq"));
            username1 = (String) future.get();
            username2 = (String) future1.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return username1 + username2;
    }

    /**
     * 测试事件通知
     * xml:event-notify.xml
     */
    @RequestMapping("/getUsername7")
    public String getUsername7(){
        return userService.getNewName("罗辑");
    }

    @RequestMapping("getUsername8")
    public String getUsername8(){
        User user = new User();
        user.setUsername("曲率驱动飞船");
        user.setAge(-1);
        return orderService.getOrderId(user).toString();
    }



}
