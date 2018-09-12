package newthreeday.com.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import newthreeday.com.moudle.CatchHandleEntity;

/**
 * Created by zhangpingzhen on 2018/9/12.
 */
@Dao
public interface CatchHandleDao {
    @Insert
    void insertCatchHandle(CatchHandleEntity catchHandleEntity);
    @Query("select*from catchhandleentity")
    List<CatchHandleEntity> queryCatchHandle();
}
