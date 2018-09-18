package com.cn.room.activity;

import android.app.Application;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;

import com.cn.room.Dao.UserDatabase;
import com.com.fiveday.baseview.ClickBaseView;
import com.com.fiveday.baseview.HandleBaseView;
import com.com.fourday.base.AccessTimeBase;
import com.com.threeday.base.ThreeDataBase;
import com.com.tworoom.source.Tworoomdatabase;
import com.facebook.stetho.Stetho;
import com.sixday.base.RetorDatabase;
import com.sixday.base.SixAccessBase;
import com.sixday.base.SixClickNumberBase;
import com.sixday.base.SixHandleBase;
import com.sixday.handle.SixCrashHandler;

import newfourday.com.ClickCrashHandler;
import newfourday.com.base.Fourdatabase;
import newthreeday.com.handle.CrashHandler;

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
    private static SixAccessBase sixAccessBase;
    private  static SixClickNumberBase sixClickBase;
    private static SixHandleBase sixHandleBase;
    private static RetorDatabase retorDatabase;
    private static Fourdatabase fourdatabase;
    @Override
    public void onCreate() {
        super.onCreate();
        initDb();
        Stetho.initializeWithDefaults(this);
     //new SixCrashHandler(this);
     //new CrashHandler(this);
     new ClickCrashHandler(this);
    }
    static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE department "
                    + " ADD COLUMN phone_num TEXT");
        }
    };



    private void initDb() {
        database= Room.databaseBuilder(this,UserDatabase.class,"database_name").allowMainThreadQueries().build();
        tworoomdatabase=Room.databaseBuilder(this,Tworoomdatabase.class,"twodatabase_name.db").allowMainThreadQueries().build();
        threeDataBase=Room.databaseBuilder(this,ThreeDataBase.class,"threedata.db").allowMainThreadQueries().build();
        accessTimeBase=Room.databaseBuilder(this,AccessTimeBase.class,"four_data.db").allowMainThreadQueries().build();
        clickBaseView=Room.databaseBuilder(this,ClickBaseView.class,"five_data.db").allowMainThreadQueries().build();
        accessTimeBase=Room.databaseBuilder(this,AccessTimeBase.class,"four_data.db").allowMainThreadQueries().build();
        handleBaseView=Room.databaseBuilder(this, HandleBaseView.class,"five_data.db").allowMainThreadQueries().build();
        sixAccessBase=Room.databaseBuilder(this, SixAccessBase.class,"six_accdata.db").allowMainThreadQueries().build();
         sixClickBase=Room.databaseBuilder(this,SixClickNumberBase.class,"six_click.db").allowMainThreadQueries().build();
     sixHandleBase=Room.databaseBuilder(this,SixHandleBase.class,"six_handle.db").allowMainThreadQueries().build();
   retorDatabase=Room.databaseBuilder(this,RetorDatabase.class,"re.db").allowMainThreadQueries().addMigrations(MIGRATION_2_3).build();
   fourdatabase=Room.databaseBuilder(this,Fourdatabase.class,"four.db").allowMainThreadQueries().build();
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

    public static SixAccessBase getSixAccessBase() {
        return sixAccessBase;
    }

    public static SixHandleBase getSixHandleBase() {
        return sixHandleBase;
    }

    public static SixClickNumberBase getSixClickBase() {
        return sixClickBase;

    }

    public static RetorDatabase getRetorDatabase() {
        return retorDatabase;
    }

    public static Fourdatabase getFourdatabase() {
        return fourdatabase;
    }
}
