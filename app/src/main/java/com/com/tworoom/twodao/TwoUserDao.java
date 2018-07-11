package com.com.tworoom.twodao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.com.tworoom.MyUser;

import java.util.List;

/**
 * Created by zhangpingzhen on 2018/7/11.
 */
@Dao
public interface TwoUserDao {
    @Insert
    void insertstartdata(MyUser myUser);

    @Query("SELECT*FROM MyUser" )
    List<MyUser> getData();
}
