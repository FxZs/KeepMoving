package com.sixday.base;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.sixday.dao.SixAccessDao;
import com.sixday.moudle.AccessEntity;

/**
 * Created by zhangpingzhen on 2018/7/19.
 */
@Database(entities = AccessEntity.class,version = 2)
public abstract class SixAccessBase extends RoomDatabase{
    public abstract SixAccessDao sixAccessDao();
}
