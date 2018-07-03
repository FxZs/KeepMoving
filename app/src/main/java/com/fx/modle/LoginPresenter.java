package com.fx.modle;

/**
 * Created by zhangpingzhen on 2018/7/3.
 */

public interface LoginPresenter {
    /*登录出现的结果 失败或者成功*/
    public void usernameError();
    public void userpwdError();
    public void loginSuccessful();
    public void loginFail();
}
