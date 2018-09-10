package com.sixday.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.sixday.moudle.News;

import java.util.List;

/**
 * Created by Administrator on 2018/8/14.
 */
@Dao
public interface RetorDao {
    @Insert
    void insertRetorNew(News news);
    @Query("select*from News")
    List<News> queryRetorNew();
}
