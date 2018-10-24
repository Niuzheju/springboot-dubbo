package com.niuzj.user;

import com.niuzj.model.ValidationParameter;

import javax.validation.GroupSequence;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public interface IValidationService {

    //验证update组的规则,即实体类中验证update方法的,save方法也要验证
    @GroupSequence(Update.class)
    @interface Save{}
    void save(@NotNull ValidationParameter parameter);

    @interface Update{}
    void udpate(@NotNull ValidationParameter parameter);

    void delete(@Min(1) int id);
}
