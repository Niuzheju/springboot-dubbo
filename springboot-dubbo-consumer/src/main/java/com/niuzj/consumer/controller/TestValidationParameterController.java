package com.niuzj.consumer.controller;

import com.alibaba.dubbo.rpc.RpcException;
import com.niuzj.model.ValidationParameter;
import com.niuzj.user.IValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Date;
import java.util.Set;

@RestController
@RequestMapping("/validation")
public class TestValidationParameterController {

    @Autowired
    private IValidationService validationService;

    /**
     * 参数校验
     * xml:parameter-validation.xml
     */
    @RequestMapping("/test01")
    public void test01(){
        ValidationParameter parameter = new ValidationParameter();
        parameter.setAge(0);
        parameter.setName("云天明");
        parameter.setEmail("2549218666");
        parameter.setExpiryDate(new Date());
        parameter.setLoginDate(new Date());
        //校验参数
        try {
            validationService.save(parameter);
        } catch (RpcException e) {
            ConstraintViolationException exception = (ConstraintViolationException) e.getCause();
            Set<ConstraintViolation<?>> violations = exception.getConstraintViolations();
            System.out.println(violations);
        }


    }
}
