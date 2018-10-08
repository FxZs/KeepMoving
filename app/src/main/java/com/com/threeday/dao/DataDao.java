package com.com.threeday.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.com.threeday.Data;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by zhangpingzhen on 2018/7/12.
 */
@Dao
public interface DataDao {
    //向数据库里面插入数据
    @Insert
    void insertData(Data mdata);
    //从数据库中查数据
    @Query("SELECT*FROM Data")
     Flowable<List<Data>> QueryData();
}
