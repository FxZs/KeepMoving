package com.com.fiveday.presenter;

import com.com.fiveday.HandleEntity;
import com.fx.base.BasePresenter;

/**
 * Created by zhangpingzhen on 2018/7/17.
 */

public interface HandlePresenter extends BasePresenter{
     void insertHandlePresenter(HandleEntity handleEntity);//数据库里面插入数据
     void queryHandlePresenter();//查询数据库里面插入的发放
     void catchhandleder();//捕获异常方法

}
