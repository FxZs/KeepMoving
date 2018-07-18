package com.com.fiveday.handle;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.Process;
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
    private static CrashHandler sInstance = null;
    private Thread.UncaughtExceptionHandler mDefaultHandler;
    private Context mContext;
    private static String TAG="CrashHandler";
    private HandleDao handleDao;
    public CrashHandler(Context context){

        this.mContext=context;
        handleDao= App.getHandleBaseView().handleDao();
        // 获取默认异常处理器
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        // 将此类设为默认异常处理器
        Thread.setDefaultUncaughtExceptionHandler(this);
    }


    @Override
    public void uncaughtException(Thread t, Throwable e) {
        if (mDefaultHandler != null) {
            mDefaultHandler.uncaughtException(t, e);
            Log.i(TAG,t.getName()+""+e.getLocalizedMessage());
            HandleEntity handleEntity=new HandleEntity();
            handleEntity.setErrorTimes("");
            handleEntity.setHandleMessage(e.getMessage());
            handleEntity.setWhichThread(t.getName());
            handleDao.insertHandleMsg(handleEntity);
        }
        Process.killProcess(Process.myPid());
        System.exit(0);
    }




}
