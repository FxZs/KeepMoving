package newfourday.com.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import entity.HandleDealWithEntity;

/**
 * Created by zhangpingzhen on 2018/9/17.
 */
@Dao
public interface HandleDealWithDao {
    @Insert
    void insertHandleDeal(HandleDealWithEntity dealWithEntity);
    @Query("select*from handleT")
    List<HandleDealWithEntity> queryDealWithDeal();
}
