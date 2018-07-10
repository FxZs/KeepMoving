package com.cn.room.presenter;

import com.cn.room.User;
import com.cn.room.UserRoomDateSource;
import com.cn.room.activity.App;
import com.cn.room.view.UserView;

/**
 * Created by zhangpingzhen on 2018/7/10.
 */

public class PresenterImp implements UserPresenter{
    private UserView userView;//他存在的价值是什么？没用到

    //因为暂时只有一个数据源，所以直接用了
    private UserRoomDateSource dateSource;

    public PresenterImp() {

        this.dateSource = new UserRoomDateSource(App.getDatabase().userDao());
    }

    @Override
    public void start() {

    }

    @Override
    public void countNumber(User user) {
        dateSource.insertUser(user);  //存入数据就写完了  好了？对啊 不然呢
    }

    //是不是一样的？是 m v p，你理解清楚了么？嗯，说实话
    //理解了接口里面定义规范
    //接口是定义规范的  与 MVP 没有直接关系
    @Override
    public void starttime(User user) {
        dateSource.insertUser(user);
    }

    @Override
    public void stoptime(User user) {
        dateSource.insertUser(user);
    }

    @Override
    public void counttime(User user) {
        dateSource.insertUser(user);
    }
}
