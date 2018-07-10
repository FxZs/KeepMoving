package com.cn.room.presenter;

import com.cn.room.User;
import com.fx.base.BasePresenter;

/**
 * Created by zhangpingzhen on 2018/7/10.
 * 接口用在这里定义了UserPresenter 需要做的事情，虽然不合理，但也没错
 */

public interface UserPresenter extends BasePresenter{
 void countNumber(User user);
 void starttime(User user);
 void stoptime(User user);
 void counttime(User user);
}
