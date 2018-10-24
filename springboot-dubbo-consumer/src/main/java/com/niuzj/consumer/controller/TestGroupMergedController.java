package com.niuzj.consumer.controller;

import com.niuzj.user.IGroupMergedService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/group")
public class TestGroupMergedController {

    @Resource(name = "groupMergedService")
    private IGroupMergedService groupMergedService;

    /**
     * 分组聚合测试
     * 数组, List, Map会调用聚合的多个分组的接口获取数据并把数据合并到一起
     * 单个数据不支持聚合,必须是数组,集合类型的返回值
     */
    @RequestMapping("test01")
    public void test01(){
        String[] array = groupMergedService.groupArray();
        System.out.println(Arrays.toString(array));
        List<String> list = groupMergedService.groupList();
        System.out.println(list);
        Map<String, String> map = groupMergedService.groupMap();
        System.out.println(map);
        Integer integer = groupMergedService.groupInteger();
        System.out.println(integer);
        String s = groupMergedService.groupString();
        System.out.println(s);
    }
}
