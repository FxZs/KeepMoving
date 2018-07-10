package com.fx.presenter;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.fx.modle.RoomUser;

/**
 * Created by zhangpingzhen on 2018/7/9.
 */
@Database(entities = RoomUser.class,version = 1)
public abstract class HyDatabase extends RoomDatabase{
    public abstract DaoUser daoUser();
}
