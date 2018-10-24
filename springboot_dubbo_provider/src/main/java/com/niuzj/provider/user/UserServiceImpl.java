package com.niuzj.provider.user;

import com.niuzj.common.CallBackListener;
import com.niuzj.user.UserService;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Override
    public String getUsername() {
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
