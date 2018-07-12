package com.com.fourday.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.com.fourday.AccessTime;

import java.util.List;

/**
 * Created by zhangpingzhen on 2018/7/12.
 */
@Dao
public interface AccessTimeDao {
    @Insert
    void insertTime(AccessTime accessTime);
    @Query("SELECT*FROM AccessTime")//这个名字要写对的吧  区分大小写的吧
    List<AccessTime> queryTime();
}
