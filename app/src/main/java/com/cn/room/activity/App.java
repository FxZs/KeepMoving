package com.cn.room.activity;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.cn.room.Dao.UserDatabase;
import com.com.fiveday.baseview.ClickBaseView;
import com.com.fiveday.baseview.HandleBaseView;
import com.com.fiveday.handle.CrashHandler;
import com.com.fourday.base.AccessTimeBase;
import com.com.threeday.base.ThreeDataBase;
import com.com.tworoom.source.Tworoomdatabase;

/**
 * Created by zhangpingzhen on 2018/7/10.
 * 官网例子说了一遍，又写了一遍，会了么 查不多啦啦
 * 看清楚我的要求哈， 嗯  mvp 分清
 */

public class App extends Application{
    private static App instance;
    private static UserDatabase database;
    private static Tworoomdatabase tworoomdatabase;
    private static ThreeDataBase threeDataBase;
    private static AccessTimeBase accessTimeBase;
    private static HandleBaseView handleBaseView;
    private Context mContext;
    private static ClickBaseView clickBaseView;
    @Override
    public void onCreate() {
        super.onCreate();
        initDb();
        new CrashHandler(this);
    }

    private void initDb() {
        database= Room.databaseBuilder(this,UserDatabase.class,"database_name").allowMainThreadQueries().build();
        tworoomdatabase=Room.databaseBuilder(this,Tworoomdatabase.class,"twodatabase_name.db").allowMainThreadQueries().build();
        threeDataBase=Room.databaseBuilder(this,ThreeDataBase.class,"threedata.db").allowMainThreadQueries().build();
        accessTimeBase=Room.databaseBuilder(this,AccessTimeBase.class,"four_data.db").allowMainThreadQueries().build();
        clickBaseView=Room.databaseBuilder(this,ClickBaseView.class,"five_data.db").allowMainThreadQueries().build();
        accessTimeBase=Room.databaseBuilder(this,AccessTimeBase.class,"four_data.db").allowMainThreadQueries().build();
        handleBaseView=Room.databaseBuilder(this, HandleBaseView.class,"five_data.db").allowMainThreadQueries().build();
    }

    public static App getInstance() {
        return instance;
    }

    public static UserDatabase getDatabase() {
        return database;
    }

    public static Tworoomdatabase getTworoomdatabase() {
        return tworoomdatabase;
    }

    public static ThreeDataBase getThreeDataBase() {
        return threeDataBase;
    }

    public static AccessTimeBase getAccessTimeBase() {
        return accessTimeBase;
    }

    public static ClickBaseView getClickBaseView() {
        return clickBaseView;
    }

    public static HandleBaseView getHandleBaseView() {
        return handleBaseView;
    }
}
