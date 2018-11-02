package com.niuzj.user;

import com.niuzj.model.User;

public class IOrderServiceMock implements IOrderService{

    @Override
    public Object getOrderId(User user) {
        return "order mock data";
    }
}
