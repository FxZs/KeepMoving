package com.cn.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;


//以你user为例 20分钟 给你写个例子，不懂了QQ说话
//1.创建实体类，这个就user了  他只是一个例子，你改它干嘛，新建一个自己写哇
//start_time stop_time
/**
 * Created by zhangpingzhen on 2018/7/10.
 */
@Entity
public class User {


    @PrimaryKey(autoGenerate = true)
    public int id;

    public String username;
    public String pwd;
    @ColumnInfo(name = "start_time")
    public String starttime;
    @ColumnInfo(name = "stop_time")
    public String stoptime;

    public String  counttime;//每次访问的时间

    @Ignore
    public User() {
    }

    public User(int id, String username, String pwd, String starttime, String stoptime, String counttime) {
        this.id = id;
        this.username = username;
        this.pwd = pwd;
        this.starttime = starttime;
        this.stoptime = stoptime;
        this.counttime = counttime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getStoptime() {
        return stoptime;
    }

    public void setStoptime(String stoptime) {
        this.stoptime = stoptime;
    }

    public String getCounttime() {
        return counttime;
    }

    public void setCounttime(String counttime) {
        this.counttime = counttime;
    }
}
