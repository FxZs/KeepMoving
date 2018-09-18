package newfourday.com.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import entity.HttpEntity;

/**
 * Created by zhangpingzhen on 2018/9/17.
 */
@Dao
public interface HttpEntityDao {
    @Insert
    void insertHttpEntity(HttpEntity httpEntity);
    @Query("select*from httpT")
    List<HttpEntity> queryHttpEntity();
}
