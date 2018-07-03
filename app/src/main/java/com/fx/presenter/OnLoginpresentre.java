package com.fx.presenter;

import com.fx.modle.LoginPresenter;
import com.fx.modle.Loginfort;
import com.fx.modle.Logininforment;
import com.fx.view.LoginViewew;

/**
 * Created by zhangpingzhen on 2018/7/3.
 */

public class OnLoginpresentre implements LoginPresenter{
private Loginfort loginfort;
private LoginViewew loginViewew;

    public OnLoginpresentre(LoginViewew loginViewew) {
        this.loginViewew = loginViewew;
        loginfort=new Logininforment();
    }
public void Login(){
        String username=loginViewew.getUsername();
        String userpwd=loginViewew.getPwd();
loginfort.Login(username,userpwd,this);
}
    @Override
    public void usernameError() {
        loginViewew.ToastShow("用户名错误!");

    }

    @Override
    public void userpwdError() {
loginViewew.ToastShow("密码错误!");
    }

    @Override
    public void loginSuccessful() {
loginViewew.ToastShow("登录成功!");
    }

    @Override
    public void loginFail() {
loginViewew.ToastShow("登录失败!");
    }
}
