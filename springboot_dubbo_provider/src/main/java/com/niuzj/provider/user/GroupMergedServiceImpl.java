package com.niuzj.provider.user;

import com.niuzj.user.IGroupMergedService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("groupMergedService")
public class GroupMergedServiceImpl implements IGroupMergedService {

    @Override
    public String[] groupArray() {
        return new String[]{"A", "B", "C"};
    }

    @Override
    public List<String> groupList() {
        List<String> list = new ArrayList<>();
        list.add("罗辑");
        list.add("维德");
        list.add("程心");
        return list;
    }

    @Override
    public Map<String, String> groupMap() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "nzj");
        map.put("age", "22");
        return map;
    }

    @Override
    public String groupString() {
        return "nzj";
    }

    @Override
    public Integer groupInteger() {
        return 1;
    }
}
