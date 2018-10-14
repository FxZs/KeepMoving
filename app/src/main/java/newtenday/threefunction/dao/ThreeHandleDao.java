package newtenday.threefunction.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import newtenday.threefunction.moundle.ThreeHandleEntity;

/**
 * Created by Administrator on 2018/10/14.
 */
@Dao
public interface ThreeHandleDao {
    @Insert
    void insertThreeHandle(ThreeHandleEntity threeHandleEntity);
    @Query("select*from threeHandleT")
    List<ThreeHandleEntity> queryThreeHandle();
    @Delete
    void deletThreeHandle(ThreeHandleEntity threeHandleEntity);
}
