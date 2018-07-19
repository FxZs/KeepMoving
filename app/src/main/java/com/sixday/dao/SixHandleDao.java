package com.sixday.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.sixday.moudle.HandleEntity;

import java.util.List;

/**
 * Created by zhangpingzhen on 2018/7/19.
 */
@Dao
public interface SixHandleDao {
    @Insert
   void insertSixHandle(HandleEntity handleEntity);
    @Query("SELECT*FROM HandleEntity")
   List<HandleEntity> querySixHandle();

}
