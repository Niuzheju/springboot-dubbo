package com.niuzj.consumer.eventnotify.impl;

import com.niuzj.consumer.eventnotify.NotifyService;

public class NotifyServiceImpl implements NotifyService {

    @Override
    public void onInvoke(String name) {
        System.out.println("方法即将被调用,参数=" + name);
    }

    @Override
    public void onReturn(String result, String name) {
        System.out.println("方法调用完毕, result=" + result + "参数=" + name);

    }

    @Override
    public void onReturnWithoutParam(String result) {
        System.out.println("方法调用完毕, result=" + result);

    }

    @Override
    public void onThrow(Throwable e, String name) {
        System.out.println("方法抛出异常:参数=" + name);
        e.printStackTrace();
    }
}
