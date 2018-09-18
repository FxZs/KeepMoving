package entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by zhangpingzhen on 2018/9/12.
 */
@Entity(tableName = "clickT")
public class ClickListerEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String whatClickTime;//点击的时间
    private String whereBtn;  //哪个按钮点击
    private String  btnText;//按钮上的内容
    private String whichMethod;//哪个方法里面点击
    private String testUser;
    private String phoneType;//什么机型
    private String whichSystem;//什么系统
    private String whichThread;//是否主线程
    private String whichPage;//当前页面是哪个

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWhatClickTime() {
        return whatClickTime;
    }

    public void setWhatClickTime(String whatClickTime) {
        this.whatClickTime = whatClickTime;
    }

    public String getWhereBtn() {
        return whereBtn;
    }

    public void setWhereBtn(String whereBtn) {
        this.whereBtn = whereBtn;
    }

    public String getBtnText() {
        return btnText;
    }

    public void setBtnText(String btnText) {
        this.btnText = btnText;
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

    public String getWhichThread() {
        return whichThread;
    }

    public void setWhichThread(String whichThread) {
        this.whichThread = whichThread;
    }

    public String getWhichPage() {
        return whichPage;
    }

    public void setWhichPage(String whichPage) {
        this.whichPage = whichPage;
    }

    @Override
    public String toString() {
        return "ClickListerEntity{" +
                "id=" + id +
                ", whatClickTime='" + whatClickTime + '\'' +
                ", whereBtn='" + whereBtn + '\'' +
                ", btnText='" + btnText + '\'' +
                ", whichMethod='" + whichMethod + '\'' +
                ", testUser='" + testUser + '\'' +
                ", phoneType='" + phoneType + '\'' +
                ", whichSystem='" + whichSystem + '\'' +
                ", whichThread='" + whichThread + '\'' +
                ", whichPage='" + whichPage + '\'' +
                '}';
    }
}
