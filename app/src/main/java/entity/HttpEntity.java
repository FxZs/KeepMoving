package entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by zhangpingzhen on 2018/9/12.
 */
@Entity(tableName = "httpT")
public class HttpEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String myUrl;
    private String myMethod;
    private String data;
    private String myBody;
    private String sendTime;
    private String whichMethod;//哪个方法发送的请求
    private String testUser;
    private String phoneType;//什么机型
    private String whichSystem;//什么系统
    private boolean isMainThread;//是否主线程

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMyUrl() {
        return myUrl;
    }

    public void setMyUrl(String myUrl) {
        this.myUrl = myUrl;
    }

    public String getMyMethod() {
        return myMethod;
    }

    public void setMyMethod(String myMethod) {
        this.myMethod = myMethod;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMyBody() {
        return myBody;
    }

    public void setMyBody(String myBody) {
        this.myBody = myBody;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getWhichMethod() {
        return whichMethod;
    }

    public void setWhichMethod(String whichMethod) {
        this.whichMethod = whichMethod;
    }

    public String getTestUser() {
        return testUser;
    }

    public void setTestUser(String testUser) {
        this.testUser = testUser;
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

    @Override
    public String toString() {
        return "HttpEntity{" +
                "id=" + id +
                ", myUrl='" + myUrl + '\'' +
                ", myMethod='" + myMethod + '\'' +
                ", data='" + data + '\'' +
                ", myBody='" + myBody + '\'' +
                ", sendTime='" + sendTime + '\'' +
                ", whichMethod='" + whichMethod + '\'' +
                ", testUser='" + testUser + '\'' +
                ", phoneType='" + phoneType + '\'' +
                ", whichSystem='" + whichSystem + '\'' +
                ", isMainThread=" + isMainThread +
                '}';
    }
}
