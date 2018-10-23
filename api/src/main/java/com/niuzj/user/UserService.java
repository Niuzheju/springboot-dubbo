package com.niuzj.user;

import com.niuzj.common.CallBackListener;

public interface UserService {
    String getUsername();

    String getUsername(CallBackListener listener);
}
