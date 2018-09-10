package newtwoday.com.moudle;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Administrator on 2018/9/10.
 */
@Entity
public class OnclickTimesNum {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String onclickTimes;
    private String whichmethod;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOnclickTimes() {
        return onclickTimes;
    }

    public void setOnclickTimes(String onclickTimes) {
        this.onclickTimes = onclickTimes;
    }

    public String getWhichmethod() {
        return whichmethod;
    }

    public void setWhichmethod(String whichmethod) {
        this.whichmethod = whichmethod;
    }

    @Override
    public String toString() {
        return "OnclickTimesNum{" +
                "id=" + id +
                ", onclickTimes='" + onclickTimes + '\'' +
                ", whichmethod='" + whichmethod + '\'' +
                '}';
    }
}
