package rxjavalian.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import rxjavalian.entity.RxjavaEntity;

/**
 * Created by Administrator on 2018/10/8.
 */
@Dao
public interface RxjavaDao {
   /* @Insert
    void  insertRxJava(RxjavaEntity rxjavaEntity);
    @Insert
    void insertRxJavaList(List<RxjavaEntity> rxjavaEntities);
    @Query("select*from rxjavaentity")
    List<RxjavaEntity> queryRxjava();
    @Query("select*from rxjavaentity where id=:id")
    RxjavaEntity queryRx();
    @Delete
    void deletRxjava(RxjavaEntity rxjavaEntity);
    @Delete
    void delectRxjavalist(List<RxjavaEntity> rxjavaEntities);
    @Update
    void updataRxjava(RxjavaEntity rxjavaEntity);
*/
}
