package com.sixday.base;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.sixday.dao.SixClickNumberDao;
import com.sixday.moudle.ClickEntity;

/**
 * Created by zhangpingzhen on 2018/7/19.
 */
@Database(entities = ClickEntity.class,version = 1)
public abstract class SixClickNumberBase extends RoomDatabase{
    public abstract SixClickNumberDao sixClickNumberDao();
}
