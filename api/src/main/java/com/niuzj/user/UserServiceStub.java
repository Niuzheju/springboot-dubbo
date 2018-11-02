package com.niuzj.user;

import com.niuzj.common.CallBackListener;

public class UserServiceStub implements UserService {

    private UserService userService;

    public UserServiceStub(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String getUsername() {
        System.out.println("userService stub");
        return userService.getUsername() + "_stub";
    }

    @Override
    public String getUsername(CallBackListener listener) {
        System.out.println("userService stub");
        return userService.getUsername(listener);
    }

    @Override
    public String getNewName(String username) {
        System.out.println("userService stub");
        return userService.getNewName(username);
    }
}
