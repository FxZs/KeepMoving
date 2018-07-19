package com.sixday.base;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.sixday.dao.SixHandleDao;
import com.sixday.moudle.HandleEntity;

/**
 * Created by zhangpingzhen on 2018/7/19.
 */
@Database(entities = HandleEntity.class,version = 1)
public abstract class SixHandleBase extends RoomDatabase{
    public abstract SixHandleDao sixHandleDao();
}
