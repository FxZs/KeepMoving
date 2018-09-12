package newthreeday.com.moudle;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by zhangpingzhen on 2018/9/12.
 */
@Entity
public class CatchHandleEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String catchTime;  //异常时间
    private String whichMethod;  //哪个方法
    private String whatHandle;  //什么异常
    public String  whichUse;
    public String phoneType; //机型
    private String androidos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCatchTime() {
        return catchTime;
    }

    public void setCatchTime(String catchTime) {
        this.catchTime = catchTime;
    }

    public String getWhichMethod() {
        return whichMethod;
    }

    public void setWhichMethod(String whichMethod) {
        this.whichMethod = whichMethod;
    }

    public String getWhatHandle() {
        return whatHandle;
    }

    public void setWhatHandle(String whatHandle) {
        this.whatHandle = whatHandle;
    }

    public String getWhichUse() {
        return whichUse;
    }

    public void setWhichUse(String whichUse) {
        this.whichUse = whichUse;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public String getAndroidos() {
        return androidos;
    }

    public void setAndroidos(String androidos) {
        this.androidos = androidos;
    }

    @Override
    public String toString() {
        return "CatchHandleEntity{" +
                "id=" + id +
                ", catchTime='" + catchTime + '\'' +
                ", whichMethod='" + whichMethod + '\'' +
                ", whatHandle='" + whatHandle + '\'' +
                ", whichUse='" + whichUse + '\'' +
                ", phoneType='" + phoneType + '\'' +
                ", androidos='" + androidos + '\'' +
                '}';
    }
}
