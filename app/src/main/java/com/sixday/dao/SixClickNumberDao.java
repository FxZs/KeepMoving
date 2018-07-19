package com.sixday.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.sixday.moudle.ClickEntity;

import java.util.List;

/**
 * Created by zhangpingzhen on 2018/7/19.
 */
@Dao
public interface SixClickNumberDao {
    @Insert
    void insertSixClickNumber(ClickEntity clickEntity);
    @Query("SELECT*FROM ClickEntity")
    List<ClickEntity> querySixClickNumber();
}
