package com.sixday.moudle;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Administrator on 2018/7/18.
 */
@Entity
public class AccessEntity implements  BaseMoudle{
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String startdata;
    public String pausedata;
   /* private String whichPage;
    private String timeslot;//停留时间*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartdata() {
        return startdata;
    }

    public void setStartdata(String startdata) {
        this.startdata = startdata;
    }

    public String getPausedata() {
        return pausedata;
    }

    public void setPausedata(String pausedata) {
        this.pausedata = pausedata;
    }

    @Override
    public String toString() {
        return "AccessEntity{" +
                "id=" + id +
                ", startdata='" + startdata + '\'' +
                ", pausedata='" + pausedata + '\'' +
                '}';
    }
}
