package com.niuzj.model;

import com.niuzj.user.IValidationService;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

public class ValidationParameter implements Serializable {

    private static final long serialVersionUID = 2651914207380710567L;

    //非空, 最小长度3, 最大长度18
    @NotNull
    @Size(min = 3, max = 18)
    private String name;

    //满足邮箱格式, 更新时邮箱非空
    @NotNull(groups = IValidationService.Save.class)
    @Pattern(regexp = "^\\\\s*\\\\w+(?:\\\\.{0,1}[\\\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\\\.[a-zA-Z]+\\\\s*$")
    private String email;

    //最大100, 最小1
    @Min(1)
    @Max(100)
    private int age;

    //必须为过去的时间
    @Past
    private Date loginDate;

    //必须为未来的时间
    @Future
    private Date expiryDate;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "ValidationParameter{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", loginDate=" + loginDate +
                ", expiryDate=" + expiryDate +
                '}';
    }
}
