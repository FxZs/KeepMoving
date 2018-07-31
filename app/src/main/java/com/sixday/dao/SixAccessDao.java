package com.sixday.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.sixday.moudle.AccessEntity;

import java.util.List;

/**
 * Created by Administrator on 2018/7/18.
 */
@Dao
public interface SixAccessDao{
    @Insert
    void insertSixAccess(AccessEntity accessEntity);

    @Query("SELECT*FROM accessentity")
    List<AccessEntity> querySixAccess();
    @Query("SELECT*FROM accessentity WHERE AccessEntity.id = :id")
    AccessEntity querySixAccessByID(String id);
}
