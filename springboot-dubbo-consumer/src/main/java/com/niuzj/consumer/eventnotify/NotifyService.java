package com.niuzj.consumer.eventnotify;

public interface NotifyService {
    /**
     * 接口方法调用之前调用本方法
     * @param name 合接口方法的参数列表保持一致
     */
    void onInvoke(String name);

    /**
     * 接口方法调用之后调用本方法
     * @param result 第一个参数为接口方法返回结果,类型和接口方法保持一致
     * @param name 第二个及后面更多参数为接口方法参数列表
     */
    void onReturn(String result, String name);

    /**
     * 接口方法调用之后调用本方法,仅接收返回结果
     * @param result 第一个参数为接口方法返回结果,类型和接口方法保持一致
     */
    void onReturnWithoutParam(String result);

    /**
     * 接口方法抛出异常时调用本方法
     * @param e 用于接收接口方法抛出的异常
     * @param name 接口方法参数列表
     */
    void onThrow(Throwable e, String name);

}
