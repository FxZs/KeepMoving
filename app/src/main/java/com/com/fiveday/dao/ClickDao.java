package com.com.fiveday.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.com.fiveday.OnclickEntity;

import java.util.List;

/**
 * Created by Administrator on 2018/7/14.
 */
@Dao
public interface ClickDao {
    @Insert
    void insertclicktime(OnclickEntity  clickEntity);
    @Query("SELECT*FROM OnclickEntity")
    List<OnclickEntity> queryclicktimes();
}
