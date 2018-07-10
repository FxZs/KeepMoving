package com.cn.room;

import com.cn.room.Dao.UserDao;

/**
 * Created by zhangpingzhen on 2018/7/10.
 * 3.实现接口
 */

public class UserRoomDateSource implements DateSource {
    private UserDao dao;

    //基本构造方法，可改进为单例模式 后期。。。
    public UserRoomDateSource(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public void insertUser(User user) {

    }

}
