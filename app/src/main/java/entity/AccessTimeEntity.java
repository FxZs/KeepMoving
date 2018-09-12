package entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

/**
 * Created by zhangpingzhen on 2018/9/12.
 */
@Entity(tableName = "accessT")
public class AccessTimeEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String startTime;
    private String resurmTime;
    private String whichUser;
    private String totalTime;
    private String phoneType;
    private String whichSystem;
    private boolean isMainThread;//是否主线程
    private String whichPageBack;//哪个页面离开
    private String whichPageGo;//哪个页面进入

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getResurmTime() {
        return resurmTime;
    }

    public void setResurmTime(String resurmTime) {
        this.resurmTime = resurmTime;
    }

    public String getWhichUser() {
        return whichUser;
    }

    public void setWhichUser(String whichUser) {
        this.whichUser = whichUser;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public String getWhichSystem() {
        return whichSystem;
    }

    public void setWhichSystem(String whichSystem) {
        this.whichSystem = whichSystem;
    }

    public boolean isMainThread() {
        return isMainThread;
    }

    public void setMainThread(boolean mainThread) {
        isMainThread = mainThread;
    }

    public String getWhichPageBack() {
        return whichPageBack;
    }

    public void setWhichPageBack(String whichPageBack) {
        this.whichPageBack = whichPageBack;
    }

    public String getWhichPageGo() {
        return whichPageGo;
    }

    public void setWhichPageGo(String whichPageGo) {
        this.whichPageGo = whichPageGo;
    }

    @Override
    public String toString() {
        return "AccessTimeEntity{" +
                "id=" + id +
                ", startTime='" + startTime + '\'' +
                ", resurmTime='" + resurmTime + '\'' +
                ", whichUser='" + whichUser + '\'' +
                ", totalTime='" + totalTime + '\'' +
                ", phoneType='" + phoneType + '\'' +
                ", whichSystem='" + whichSystem + '\'' +
                ", isMainThread=" + isMainThread +
                ", whichPageBack='" + whichPageBack + '\'' +
                ", whichPageGo='" + whichPageGo + '\'' +
                '}';
    }
}
