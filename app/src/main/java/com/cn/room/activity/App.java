package com.cn.room.activity;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.cn.room.Dao.UserDatabase;

/**
 * Created by zhangpingzhen on 2018/7/10.
 * 官网例子说了一遍，又写了一遍，会了么 查不多啦啦
 * 看清楚我的要求哈， 嗯  mvp 分清
 */

public class App extends Application{
    private static App instance;
    private static UserDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        initDb();
    }

    private void initDb() {
        database= Room.databaseBuilder(this,UserDatabase.class,"database_name").build();
    }

    public static App getInstance() {
        return instance;
    }

    public static UserDatabase getDatabase() {
        return database;
    }
}
