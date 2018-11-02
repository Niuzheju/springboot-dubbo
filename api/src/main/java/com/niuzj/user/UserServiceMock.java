package com.niuzj.user;

import com.niuzj.common.CallBackListener;

public class UserServiceMock implements UserService{

    @Override
    public String getUsername() {
        return "容错数据";
    }

    @Override
    public String getUsername(CallBackListener listener) {
        return "容错数据";
    }

    @Override
    public String getNewName(String username) {
        return "容错数据";
    }
}
