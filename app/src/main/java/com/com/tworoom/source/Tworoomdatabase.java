package com.com.tworoom.source;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomDatabase;

import com.cn.room.User;
import com.com.tworoom.MyUser;
import com.com.tworoom.twodao.TwoUserDao;

/**
 * Created by zhangpingzhen on 2018/7/11.
 */
@Database(entities = {MyUser.class},version = 1)
public abstract class Tworoomdatabase extends RoomDatabase{
    public abstract TwoUserDao twoUserDao();

    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }
}
