package newfourday.com;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import entity.AccessTimeEntity;

/**
 * Created by Administrator on 2018/9/12.
 */
@Dao
public interface NewAccessDao {
    @Insert
    void insertNewAccessTime(AccessTimeEntity accessTimeEntity);
    @Query("select*from accessT")
    List<AccessTimeEntity> queryNewAccessTime();
    @Query("select*from accessT where phoneType=android")
    List<AccessTimeEntity> queryPhoneType(String phoneType);
}
