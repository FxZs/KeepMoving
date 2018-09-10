package newday.com.moudle;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Administrator on 2018/9/10.
 */
@Entity
public class InterTimeEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String startTime;
    private String pauseTime;
    private String whichmethod;
    private String whichhandle;

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

    public String getPauseTime() {
        return pauseTime;
    }

    public void setPauseTime(String pauseTime) {
        this.pauseTime = pauseTime;
    }

    public String getWhichmethod() {
        return whichmethod;
    }

    public void setWhichmethod(String whichmethod) {
        this.whichmethod = whichmethod;
    }

    public String getWhichhandle() {
        return whichhandle;
    }

    public void setWhichhandle(String whichhandle) {
        this.whichhandle = whichhandle;
    }

    @Override
    public String toString() {
        return "InterTimeEntity{" +
                "id=" + id +
                ", startTime='" + startTime + '\'' +
                ", pauseTime='" + pauseTime + '\'' +
                ", whichmethod='" + whichmethod + '\'' +
                ", whichhandle='" + whichhandle + '\'' +
                '}';
    }
}
