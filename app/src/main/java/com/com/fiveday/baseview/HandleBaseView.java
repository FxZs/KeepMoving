package com.com.fiveday.baseview;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.com.fiveday.HandleEntity;
import com.com.fiveday.dao.HandleDao;

/**
 * Created by zhangpingzhen on 2018/7/17.
 */
@Database(entities = HandleEntity.class,version = 1)
public abstract class HandleBaseView extends RoomDatabase{
    public abstract HandleDao handleDao();
}
