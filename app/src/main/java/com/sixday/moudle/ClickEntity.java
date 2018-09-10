package com.sixday.moudle;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by zhangpingzhen on 2018/7/19.
 */
@Entity
public class ClickEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String clickBtnTime;
    public String clickBtnText;
    public String btnNextDecriber;
    public String whichPage;
   /* public String  whichUse="测试";*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClickBtnTime() {
        return clickBtnTime;
    }

    public void setClickBtnTime(String clickBtnTime) {
        this.clickBtnTime = clickBtnTime;
    }

    public String getClickBtnText() {
        return clickBtnText;
    }

    public void setClickBtnText(String clickBtnText) {
        this.clickBtnText = clickBtnText;
    }

    public String getBtnNextDecriber() {
        return btnNextDecriber;
    }

    public void setBtnNextDecriber(String btnNextDecriber) {
        this.btnNextDecriber = btnNextDecriber;
    }

    public String getWhichPage() {
        return whichPage;
    }

    public void setWhichPage(String whichPage) {
        this.whichPage = whichPage;
    }

    @Override
    public String toString() {
        return "ClickEntity{" +
                "id=" + id +
                ", 点击按钮时间='" + clickBtnTime + '\'' +
                ", 点击按钮文本='" + clickBtnText + '\'' +
                ", 点击按钮后描述='" + btnNextDecriber + '\'' +
                ", 那一页='" + whichPage + '\'' +
                '}';
    }
}
