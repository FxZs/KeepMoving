package com.fx.modle;

/**
 * Created by zhangpingzhen on 2018/7/3.
 * 现在做的是登录，业务逻辑是围绕User （用户）进行的，现在进行对User的封装
 */

public class User {
    public  String name;
    public  String pwd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
