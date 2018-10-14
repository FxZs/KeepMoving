package newtenday.firstfunction.moundle;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by zhangpingzhen on 2018/10/12.
 */
@Entity(tableName = "firstAccessT")
public class FristAccessEntity {
    @PrimaryKey
    private Integer id;

    private String startTime;
    private String resurmTime;//离开时间
    private String whichUser;
    private String totalTime;//总共时间
    private String phoneType;//手机类型
    private String whichSystem; //什么系统
    private String threadName;//是否主线程
    private String whichPage;//哪个页面

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public String getWhichPage() {
        return whichPage;
    }

    public void setWhichPage(String whichPage) {
        this.whichPage = whichPage;
    }

    @Override
    public String toString() {
        return "FristAccessEntity{" +
                "id=" + id +
                ", startTime='" + startTime + '\'' +
                ", resurmTime='" + resurmTime + '\'' +
                ", whichUser='" + whichUser + '\'' +
                ", totalTime='" + totalTime + '\'' +
                ", phoneType='" + phoneType + '\'' +
                ", whichSystem='" + whichSystem + '\'' +
                ", threadName='" + threadName + '\'' +
                ", whichPage='" + whichPage + '\'' +
                '}';
    }
}
