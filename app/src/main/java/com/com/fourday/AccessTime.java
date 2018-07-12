package com.com.fourday;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by zhangpingzhen on 2018/7/12.
 */
@Entity
public class AccessTime {
    @PrimaryKey(autoGenerate = true)
    public int anId;
    public String startAccess; //记录开始访问时间
    public String stopAccess;  //记录结束访问时间

    public int getAnId() {
        return anId;
    }

    public void setAnId(int anId) {
        this.anId = anId;
    }

    public String getStartAccess() {
        return startAccess;
    }

    public void setStartAccess(String startAccess) {
        this.startAccess = startAccess;
    }

    public String getStopAccess() {
        return stopAccess;
    }

    public void setStopAccess(String stopAccess) {
        this.stopAccess = stopAccess;
    }
}
