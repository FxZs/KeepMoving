package newfourday.com.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import entity.ClickListerEntity;

/**
 * Created by zhangpingzhen on 2018/9/17.
 */
@Dao
public interface ClickListerDao {
    @Insert
    void insertClickLister(ClickListerEntity clickListerEntity);
    @Query("select*from clickT")
    List<ClickListerEntity>  queryClickLister();
}
