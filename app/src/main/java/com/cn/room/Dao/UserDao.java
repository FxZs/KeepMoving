package com.cn.room.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.cn.room.User;

import java.util.List;

/**
 * Created by zhangpingzhen on 2018/7/10.
 */
@Dao
public interface UserDao {

    @Insert
    void  insertUser(User user);
//    @Insert
//    void  insertStarttime(User user);//插入开始访问的时间
//    @Insert
//    void insertStoptime(User user);//插入结束访问的时间
//    @Insert
//    void insertCounttime(User user);//插入总共访问的时间
//    @Update
//    void updataUser(User users);
//    @Delete
//    void deleteUser(User users);
//    @Query("SELECT*FROM User")
//    List<User> searchallusers();


}
