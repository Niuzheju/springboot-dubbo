package com.niuzj.provider.user;

import com.alibaba.dubbo.rpc.RpcContext;
import com.niuzj.common.CallBackListener;
import com.niuzj.user.UserService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Override
    public String getUsername() {
        //测试隐式传参
        RpcContext context = RpcContext.getContext();
        Object info = context.getAttachment("info");
        Map<String, String> map = context.getAttachments();
        System.out.println("隐式传参, param=" + info);
        return "niuzheju";
    }

    @Override
    public String getUsername(CallBackListener listener) {
        return "niuzheju" + listener.newName();
    }

    @Override
    public String getNewName(String username) {
//        int i = 10 / 0;
        return username + "_dubbo";
    }

}
