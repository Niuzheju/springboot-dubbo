package com.niuzj.provider.user;

import com.alibaba.dubbo.rpc.service.GenericException;
import com.alibaba.dubbo.rpc.service.GenericService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service("genericServiceImpl")
public class GenericServiceImpl implements GenericService {

    @Override
    public Object $invoke(String method, String[] parameterTypes, Object[] params) throws GenericException {
        System.out.println("方法名:" + method);
        System.out.println("参数类型列表:" + Arrays.toString(parameterTypes));
        System.out.println("参数列表:" + Arrays.toString(params));
        return System.currentTimeMillis();

    }
}
