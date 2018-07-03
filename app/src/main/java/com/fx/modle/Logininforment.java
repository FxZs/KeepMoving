package com.fx.modle;

/**
 * Created by zhangpingzhen on 2018/7/3.
 */

public class Logininforment implements Loginfort{
    @Override
    public void Login(String username, String pwd, LoginPresenter loginPresenter) {
        if (!username.equals("admin")||!pwd.equals("123456")){
            loginPresenter.usernameError();
        }else if(username.equals("admin")&&pwd.equals("123456")){
            loginPresenter.loginSuccessful();
        }else{
            loginPresenter.loginFail();
        }
    }
}
