package com.sixday.base;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.sixday.dao.RetorDao;
import com.sixday.moudle.News;

import newday.com.dao.InterTimeDao;
import newday.com.moudle.InterTimeEntity;
import newthreeday.com.dao.CatchHandleDao;
import newthreeday.com.moudle.CatchHandleEntity;
import newtwoday.com.dao.OnclickTimeNumDao;
import newtwoday.com.moudle.OnclickTimesNum;

/**
 * Created by Administrator on 2018/8/14.
 * User.class, UserPerforms.class
 */
@Database(entities = {News.class, InterTimeEntity.class, OnclickTimesNum.class, CatchHandleEntity.class},version = 3)
public abstract class RetorDatabase extends RoomDatabase{
    public abstract RetorDao retorDao();
    public abstract InterTimeDao interTimeDao();
    public abstract OnclickTimeNumDao onclickTimeNumDao();

    public abstract CatchHandleDao catchHandleDao();
}
