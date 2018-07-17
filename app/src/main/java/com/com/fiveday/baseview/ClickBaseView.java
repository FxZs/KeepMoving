package com.com.fiveday.baseview;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

import com.com.fiveday.OnclickEntity;
import com.com.fiveday.dao.ClickDao;

/**
 * Created by Administrator on 2018/7/14.
 */
@Database(entities = OnclickEntity.class,version = 1)
public abstract class ClickBaseView extends RoomDatabase{
    public abstract ClickDao clickDao();
}
