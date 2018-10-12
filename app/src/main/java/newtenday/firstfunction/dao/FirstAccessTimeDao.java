package newtenday.firstfunction.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import newtenday.firstfunction.moundle.FristAccessEntity;

/**
 * Created by zhangpingzhen on 2018/10/12.
 */
@Dao
public interface FirstAccessTimeDao {
    @Insert
    void  insertFirstAccess(FristAccessEntity fristAccessEntity);
    @Query("select*from firstAccessT")
    List<FristAccessEntity> queryFirstAccess();
    @Query("select*from firstAccessT")
    List<FristAccessEntity> queryFirstAccessTerm();
      @Delete
     void delectFirstAccess(FristAccessEntity fristAccessEntity);

}
