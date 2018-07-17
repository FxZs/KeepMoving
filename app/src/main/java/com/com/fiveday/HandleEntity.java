package com.com.fiveday;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by zhangpingzhen on 2018/7/17. 异常的内容呢？一会加上，设计的时候想好了哇，表建好了改起来麻烦
 */
@Entity
public class HandleEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String errorTimes;//捕获异常时间
    public String whichThread;//哪个线程出现异常
    public String HandleMessage;//异常的内容

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getErrorTimes() {
        return errorTimes;
    }

    public void setErrorTimes(String errorTimes) {
        this.errorTimes = errorTimes;
    }

    public String getWhichThread() {
        return whichThread;
    }

    public void setWhichThread(String whichThread) {
        this.whichThread = whichThread;
    }

    public String getHandleMessage() {
        return HandleMessage;
    }

    public void setHandleMessage(String handleMessage) {
        HandleMessage = handleMessage;
    }

    @Override
    public String toString() {
        return "HandleEntity{" +
                "id=" + id +
                ", errorTimes='" + errorTimes + '\'' +
                ", whichThread='" + whichThread + '\'' +
                ", HandleMessage='" + HandleMessage + '\'' +
                '}';
    }
}
