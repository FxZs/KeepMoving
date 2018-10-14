package newtenday.twofunction.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import newtenday.twofunction.mounder.TwoClickEntity;

/**
 * Created by Administrator on 2018/10/13.
 */
@Dao
public interface TwoClickDao {
    @Insert
    void insertTwoClick(TwoClickEntity twoClickEntity);
    @Query("select*from twoT")
    List<TwoClickEntity> queryTwoClickAll();
    @Delete
    void delectTwoClick(TwoClickEntity twoClickEntity);
}
