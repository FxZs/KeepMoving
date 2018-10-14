package newtenday.threefunction.moundle;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Administrator on 2018/10/14.
 */
@Entity(tableName = "threeHandleT")
public class ThreeHandleEntity {
    @PrimaryKey
    private Integer id;
    private String whatHandle;//什么异常
    private String handleTime;//产生异常时间
    private String hanldeMethod;//哪个方法里面异常
    private String handlePage;//异常产生的当前页面
    private String testUser;
    private String phoneType;//什么机型
    private String whichSystem;//什么系统
    private String whichThread;//哪个线程

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWhatHandle() {
        return whatHandle;
    }

    public void setWhatHandle(String whatHandle) {
        this.whatHandle = whatHandle;
    }

    public String getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(String handleTime) {
        this.handleTime = handleTime;
    }

    public String getHanldeMethod() {
        return hanldeMethod;
    }

    public void setHanldeMethod(String hanldeMethod) {
        this.hanldeMethod = hanldeMethod;
    }

    public String getHandlePage() {
        return handlePage;
    }

    public void setHandlePage(String handlePage) {
        this.handlePage = handlePage;
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

    public String getWhichThread() {
        return whichThread;
    }

    public void setWhichThread(String whichThread) {
        this.whichThread = whichThread;
    }

    @Override
    public String toString() {
        return "ThreeHandleEntity{" +
                "id=" + id +
                ", whatHandle='" + whatHandle + '\'' +
                ", handleTime='" + handleTime + '\'' +
                ", hanldeMethod='" + hanldeMethod + '\'' +
                ", handlePage='" + handlePage + '\'' +
                ", testUser='" + testUser + '\'' +
                ", phoneType='" + phoneType + '\'' +
                ", whichSystem='" + whichSystem + '\'' +
                ", whichThread='" + whichThread + '\'' +
                '}';
    }
}
