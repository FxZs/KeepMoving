package com.com.fiveday;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Administrator on 2018/7/14.
 */
@Entity
public class OnclickEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;

    //public int clicktimes;

    public String times;//点击时间
    public String text;//点击按钮上的文字
    public String username;
    public String describe;//点击按钮后腰做的事
    public String pagename;

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getPagename() {
        return pagename;
    }

    public void setPagename(String pagename) {
        this.pagename = pagename;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "点击信息{" +
                ", 点击时间='" + times + '\'' +
                ", 文本内容='" + text + '\'' +
                ", 点击用户='" + username + '\'' +
                ", 功能描述='" + describe + '\'' +
                ", 页面名称='" + pagename + '\'' +
                '}';
    }
}
