package com.fx.presenter;

import android.arch.persistence.room.RoomDatabase;

/**
 * Created by Administrator on 2018/7/9.
 */

public abstract class AppDatabase extends RoomDatabase{
    public abstract StudentDao studentDao();
}
