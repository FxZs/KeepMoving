package com.cn.room.activity;

import android.view.View;

import com.com.fiveday.OnclickEntity;
import com.sixday.moudle.ClickEntity;

import java.util.Calendar;

/**
 * Created by Administrator on 2018/7/14.
 */

public abstract class NoDoubleClickListener implements View.OnClickListener{
    public static final int MIN_CLICK_DELAY_TIME=1000;
    private long last_time=0;


    @Override
    public void onClick(View v) {

        long current_time= Calendar.getInstance().getTimeInMillis();
        if (current_time-last_time>MIN_CLICK_DELAY_TIME){
            last_time=current_time;
            onNoDoubleClick(v);
            OnclickEntity onclickEntity=new OnclickEntity();
            onCachClick(onclickEntity);
            ClickEntity clickEntity=new ClickEntity();
            onSixClickCach(clickEntity);
        }
    }

    protected abstract void onSixClickCach(ClickEntity clickEntity);

    protected abstract void onNoDoubleClick(View v);
    protected abstract void onCachClick(OnclickEntity entity);
}
