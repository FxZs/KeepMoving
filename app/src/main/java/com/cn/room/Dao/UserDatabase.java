package com.cn.room.Dao;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.cn.room.User;

/**
 * Created by zhangpingzhen on 2018/7/10.
 */
@Database(entities = {User.class},version = 1)//数据库注解
public abstract class UserDatabase extends RoomDatabase{
    public abstract UserDao userDao();
}
