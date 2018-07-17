package com.com.fiveday.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.com.fiveday.HandleEntity;

import java.util.List;

/**
 * Created by zhangpingzhen on 2018/7/17. 那个捕获的异常通过insert插入到数据库。。。。
 * 这个里面有两个方法  一个插入数据 一个查询
 * 数据库怎么捕获异常哇。。。哇哈哈  你先忙你的  一会找你哈
 */
@Dao
public interface HandleDao {
    @Insert
    void insertHandleMsg(HandleEntity handleEntity);
    @Query("SELECT*FROM HandleEntity")
    List<HandleEntity>  queryHandleMsg();
}
