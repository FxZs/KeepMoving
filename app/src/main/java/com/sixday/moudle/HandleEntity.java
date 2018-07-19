package com.sixday.moudle;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by zhangpingzhen on 2018/7/19.
 */
@Entity
public class HandleEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String errorHandleTime;
    public String whichThread;
    public String handleMessage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getErrorHandleTime() {
        return errorHandleTime;
    }

    public void setErrorHandleTime(String errorHandleTime) {
        this.errorHandleTime = errorHandleTime;
    }

    public String getWhichThread() {
        return whichThread;
    }

    public void setWhichThread(String whichThread) {
        this.whichThread = whichThread;
    }

    public String getHandleMessage() {
        return handleMessage;
    }

    public void setHandleMessage(String handleMessage) {
        this.handleMessage = handleMessage;
    }

    @Override
    public String toString() {
        return "HandleEntity{" +
                "id=" + id +
                ", errorHandleTime='" + errorHandleTime + '\'' +
                ", whichThread='" + whichThread + '\'' +
                ", handleMessage='" + handleMessage + '\'' +
                '}';
    }
}
