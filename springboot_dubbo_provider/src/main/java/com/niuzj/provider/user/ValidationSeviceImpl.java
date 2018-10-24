package com.niuzj.provider.user;

import com.niuzj.model.ValidationParameter;
import com.niuzj.user.IValidationService;
import org.springframework.stereotype.Service;

@Service("validationService")
public class ValidationSeviceImpl implements IValidationService {

    @Override
    public void save(ValidationParameter parameter) {
        System.out.println("save ... " + parameter);
    }

    @Override
    public void udpate(ValidationParameter parameter) {
        System.out.println("update ... " + parameter);

    }

    @Override
    public void delete(int id) {
        System.out.println("已删除 " + id);

    }
}
