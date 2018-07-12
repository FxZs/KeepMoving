package com.com.threeday;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by zhangpingzhen on 2018/7/12.
 */
@Entity//实体类要切合实际 这个够贴合了吧  都data数据了
public class Data {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String onstarttime;//这些也不规范
    public String onresumetime;
    public String statisticaltime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOnstarttime() {
        return onstarttime;
    }

    public void setOnstarttime(String onstarttime) {
        this.onstarttime = onstarttime;
    }

    public String getOnresumetime() {
        return onresumetime;
    }

    public void setOnresumetime(String onresumetime) {
        this.onresumetime = onresumetime;
    }

    public String getStatisticaltime() {
        return statisticaltime;
    }

    public void setStatisticaltime(String statisticaltime) {
        this.statisticaltime = statisticaltime;
    }
}
