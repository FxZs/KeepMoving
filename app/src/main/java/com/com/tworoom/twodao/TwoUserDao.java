package com.com.tworoom.twodao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

import com.com.tworoom.MyUser;

/**
 * Created by zhangpingzhen on 2018/7/11.
 */
@Dao
public interface TwoUserDao {
    @Insert
    void insertstartdata(MyUser myUser);
}
