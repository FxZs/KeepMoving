package com.fx.presenter;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.fx.modle.RoomUser;
import com.fx.modle.User;

import java.util.List;

/**
 * Created by zhangpingzhen on 2018/7/9.
 */
@Dao
public interface DaoUser {



    /*@Update
     void updateUsers(User users);
    @Delete
    void deleteUsers(User users);

    @Query("select*from RoomUser")
    List<RoomUser> searchAllUsers();

    @Query("select*from RoomUser where :age>18")
     List<RoomUser> searchUsersByAge(int age);*/




}
