package newtwoday.com.tools;

import android.util.Log;
import android.view.View;

import com.com.fiveday.OnclickEntity;
import com.sixday.moudle.ClickEntity;

import java.util.Calendar;

import newtwoday.com.moudle.OnclickTimesNum;

/**
 * Created by zhangpingzhen on 2018/9/11.
 */

public abstract class ButtonUtils implements View.OnClickListener{
    public static final int MIN_CLICK_DELAY_TIME=1000;
    private long last_time=0;


    @Override
    public void onClick(View v) {

        long current_time= Calendar.getInstance().getTimeInMillis();
        if (current_time-last_time>MIN_CLICK_DELAY_TIME){
            last_time=current_time;
            onNoDoubleClick(v);
            OnclickTimesNum onclickTimesNum=new OnclickTimesNum();
            onCachClick(onclickTimesNum);

            onSixClickCach(onclickTimesNum);
        }
    }

    protected abstract void onSixClickCach(OnclickTimesNum onclickTimesNum);

    protected abstract void onNoDoubleClick(View v);
    protected abstract void onCachClick(OnclickTimesNum onclickTimesNum);

}

