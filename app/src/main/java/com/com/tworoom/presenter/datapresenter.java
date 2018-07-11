package com.com.tworoom.presenter;

import com.com.tworoom.MyUser;
import com.fx.base.BasePresenter;

/**
 * Created by zhangpingzhen on 2018/7/11.
 * 注意命名规范 首字母大写
 */

public interface datapresenter extends BasePresenter{
    //之前这块写的是登录方法，相当于验证登录是否成功，现在不需要验证了，应该写什么
    //这写啥   现在不需要验证之类的方法  人呢
    //想想你现在需要做的事情。将你的收集到的数据插入到数据库，然后你又做了界面，就需要将数据读出来
    //然后更新界面。
    void  totaltime(MyUser usertime);
}
