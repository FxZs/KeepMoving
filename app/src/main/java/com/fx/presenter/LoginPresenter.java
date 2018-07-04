package com.fx.presenter;

import com.fx.base.BasePresenter;
import com.fx.modle.User;

/**
 * Created by zhangpingzhen on 2018/7/3.
 * 在这里定义你需要做的事情
 * 1.登录
 */

public interface LoginPresenter extends BasePresenter{
    void login(User user);
}
