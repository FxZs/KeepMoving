package newday.com.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Flowable;
import newday.com.moudle.InterTimeEntity;

/**
 * Created by Administrator on 2018/9/10.
 */
@Dao
public interface InterTimeDao {
    @Insert
    void insertInterTime(InterTimeEntity interTimeEntity);

    @Query("SELECT*FROM interTimeEntity")
      Flowable< List<InterTimeEntity>> queryInterTime();
}
