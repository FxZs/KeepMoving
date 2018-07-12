package com.com.threeday.base;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.com.threeday.Data;
import com.com.threeday.dao.DataDao;

/**
 * Created by zhangpingzhen on 2018/7/12.
 */
@Database(entities = Data.class,version = 1)
public abstract class ThreeDataBase extends RoomDatabase{
    public abstract DataDao mdatadao();
}
