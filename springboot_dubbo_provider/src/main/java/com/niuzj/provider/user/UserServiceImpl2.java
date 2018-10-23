package com.niuzj.provider.user;

import com.niuzj.common.CallBackListener;
import com.niuzj.user.UserService;
import org.springframework.stereotype.Service;

/**
 * @author niuzheju
 * @date 2018/10/13 17:23
 */
@Service("userService2")
public class UserServiceImpl2 implements UserService {

    @Override
    public String getUsername() {
        return "Zhangyuqiao";
    }

    @Override
    public String getUsername(CallBackListener listener) {
        return "Zhangyuqiao" + listener.newName();
    }
}
