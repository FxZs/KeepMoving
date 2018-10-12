package newtenday.database;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomDatabase;

import newtenday.firstfunction.dao.FirstAccessTimeDao;
import newtenday.firstfunction.moundle.FristAccessEntity;

/**
 * Created by zhangpingzhen on 2018/10/12.
 */
@Database(entities = {FristAccessEntity.class},version = 1)
public abstract class NewTenDataBase extends RoomDatabase {
  public   abstract FirstAccessTimeDao firstAccessTimeDao();
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }
}
