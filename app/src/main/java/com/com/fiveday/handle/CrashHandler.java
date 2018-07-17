package com.com.fiveday.handle;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.cn.room.activity.App;
import com.cn.room.activity.R;
import com.com.fiveday.FiveActivity;
import com.com.fiveday.HandleEntity;
import com.com.fiveday.dao.HandleDao;

import java.util.Calendar;

/**
 * Created by zhangpingzhen on 2018/7/17.
 */

public class CrashHandler implements Thread.UncaughtExceptionHandler{
    private Thread.UncaughtExceptionHandler mDefaultHandler;
    private Context mContext;
    private HandleDao handleDao;
    public CrashHandler(Context context){

        this.mContext=context;
        // 获取默认异常处理器
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();

        // 将此类设为默认异常处理器
        Thread.setDefaultUncaughtExceptionHandler(this);
        handleDao= App.getHandleBaseView().handleDao();
    }


    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Log.i("uncaughtException",t.getName()+e.getMessage());
            if (mDefaultHandler != null) {
//                mDefaultHandler.uncaughtException(t, e);
                HandleEntity handleEntity=new HandleEntity();
                handleEntity.setErrorTimes(Calendar.getInstance().getTime().toString());
                handleEntity.setWhichThread(t.getName());
                handleEntity.setHandleMessage(e.getMessage());
                handleDao.insertHandleMsg(handleEntity);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(0);
        } else {
            // 已经人为处理,系统自己退出
//                Thread.sleep(1000);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(0);

        }
    }




}
