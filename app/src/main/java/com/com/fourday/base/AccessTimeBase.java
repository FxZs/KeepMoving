package com.com.fourday.base;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

import com.com.fourday.AccessTime;
import com.com.fourday.dao.AccessTimeDao;

/**
 * Created by zhangpingzhen on 2018/7/12.
 */
@Database(entities = AccessTime.class ,version = 1)
public abstract class AccessTimeBase extends RoomDatabase{
   public abstract AccessTimeDao accessTimeDao();
}
