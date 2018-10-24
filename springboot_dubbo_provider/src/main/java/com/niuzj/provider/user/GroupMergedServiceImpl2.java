package com.niuzj.provider.user;

import com.niuzj.user.IGroupMergedService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("groupMergedService2")
public class GroupMergedServiceImpl2 implements IGroupMergedService {

    @Override
    public String[] groupArray() {
        return new String[]{"D", "E", "F"};
    }

    @Override
    public List<String> groupList() {
        List<String> list = new ArrayList<>();
        list.add("丁仪");
        list.add("杨冬");
        list.add("汪淼");
        return list;
    }

    @Override
    public Map<String, String> groupMap() {
        Map<String, String> map = new HashMap<>();
        map.put("length", "18");
        map.put("hair", "black");
        return map;
    }

    @Override
    public String groupString() {
        return "zyq";
    }

    @Override
    public Integer groupInteger() {
        return 2;
    }
}
