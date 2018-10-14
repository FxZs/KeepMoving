package newtenday.database;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomDatabase;

import newtenday.firstfunction.dao.FirstAccessTimeDao;
import newtenday.firstfunction.moundle.FristAccessEntity;
import newtenday.threefunction.dao.ThreeHandleDao;
import newtenday.threefunction.moundle.ThreeHandleEntity;
import newtenday.twofunction.dao.TwoClickDao;
import newtenday.twofunction.mounder.TwoClickEntity;

/**
 * Created by zhangpingzhen on 2018/10/12.
 */
@Database(entities = {FristAccessEntity.class, TwoClickEntity.class, ThreeHandleEntity.class},version = 2)
public abstract class NewTenDataBase extends RoomDatabase {
  public  abstract FirstAccessTimeDao firstAccessTimeDao();
  public abstract ThreeHandleDao threeHandleDao();

  public abstract TwoClickDao twoClickDao();

    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }
}
