package com.fx.modle;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.graphics.Bitmap;
import android.location.Address;

/**
 * Created by zhangpingzhen on 2018/7/9.
 */
@Entity(indices = {@Index(value = "firstname" ,unique = true)})
public class RoomUser {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String firstname;
    public String lastname;
    public int age;

    @Ignore
    public Bitmap bitmap;



    @Ignore
    public RoomUser() {
    }

    public RoomUser(int id, String firstname, String lastname, int age) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }
}
