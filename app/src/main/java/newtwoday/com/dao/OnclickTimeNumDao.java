package newtwoday.com.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import newtwoday.com.moudle.OnclickTimesNum;

/**
 * Created by Administrator on 2018/9/10.
 */
@Dao
public interface OnclickTimeNumDao {
    @Insert
    void insertOnClickNum(OnclickTimesNum onclickTimesNum);
    @Query("SELECT*FROM onclicktimesnum")
    List<OnclickTimesNum> queryOnclickNum();
}
