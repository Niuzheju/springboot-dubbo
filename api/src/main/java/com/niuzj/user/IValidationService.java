package com.niuzj.user;

import com.niuzj.model.ValidationParameter;

import javax.validation.GroupSequence;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public interface IValidationService {

    @GroupSequence(Update.class)
    @interface Save{}
    void save(ValidationParameter parameter);

    @interface Update{}
    void udpate(@NotNull ValidationParameter parameter);

    void delete(@Min(1) int id);
}
