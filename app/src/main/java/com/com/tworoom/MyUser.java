package com.com.tworoom;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by zhangpingzhen on 2018/7/11.
 * 敢不敢改个类名啊，全都叫user 不一样的好么，能起个符合实际的名字么？
 * 说说这个类的问题吧 说
 * startdata 触发赋值是在 onstart
 *
 * 因为你把两个时间分开定义了   都可以。
 * 按照你的理解就是 onstart onpause 必须成对出现在一条记录里，是这样么？
 * 第一次肯定只有开始时间  退出后才有结束时间，一定要确认好统计规则的要不然P很难写，P里面写统计方法  就类似结束时间减去开始时间   就是你访问的总时间，
 * 访问次数怎么统计？只算出去多少次  就是次数
 * 那你先按你先的去写 好
 */
@Entity
public class MyUser {
    @PrimaryKey(autoGenerate = true)
    public int userid;

    public String startdata;
    public String stopdata;
    public String alldata;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getStartdata() {
        return startdata;
    }

    public void setStartdata(String startdata) {
        this.startdata = startdata;
    }

    public String getStopdata() {
        return stopdata;
    }

    public void setStopdata(String stopdata) {
        this.stopdata = stopdata;
    }

    public String getAlldata() {
        return alldata;
    }

    public void setAlldata(String alldata) {
        this.alldata = alldata;
    }
}
