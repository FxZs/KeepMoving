package com.sixday.moudle;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Administrator on 2018/8/13.
 */
@Entity
public class News {
    @PrimaryKey(autoGenerate = true)
    private Integer id;
    private String requestMethord;
    private String requestTime;
    private String requestUrl;
    private String requestBody;
    private boolean ishttp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRequestMethord() {
        return requestMethord;
    }

    public void setRequestMethord(String requestMethord) {
        this.requestMethord = requestMethord;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public boolean isIshttp() {
        return ishttp;
    }

    public void setIshttp(boolean ishttp) {
        this.ishttp = ishttp;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", requestMethord='" + requestMethord + '\'' +
                ", requestTime='" + requestTime + '\'' +
                ", requestUrl='" + requestUrl + '\'' +
                ", requestBody='" + requestBody + '\'' +
                ", ishttp=" + ishttp +
                '}';
    }
}
