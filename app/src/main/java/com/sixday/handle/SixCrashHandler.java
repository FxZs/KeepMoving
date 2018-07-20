package com.sixday.handle;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.util.Log;

import com.cn.room.activity.App;
import com.cn.room.activity.RoomActivity;
import com.sixday.SixActivity;
import com.sixday.dao.SixHandleDao;
import com.sixday.moudle.HandleEntity;

/**
 * Created by zhangpingzhen on 2018/7/19.
 */

public class SixCrashHandler implements Thread.UncaughtExceptionHandler{
    private static com.com.fiveday.handle.CrashHandler sInstance = null;
    private Thread.UncaughtExceptionHandler mDefaultHandler;
    private Context mContext;
    private static String TAG="SixCrashHandler";
    private SixHandleDao sixHandleDao;
    public SixCrashHandler(Context context){

        this.mContext=context;
        sixHandleDao= App.getSixHandleBase().sixHandleDao();
        // 获取默认异常处理器
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        // 将此类设为默认异常处理器
        Thread.setDefaultUncaughtExceptionHandler(this);
    }


    @Override
    public void uncaughtException(Thread t, Throwable e) {
        if (mDefaultHandler != null) {
            Log.i(TAG,t.getName()+""+e.getLocalizedMessage());
            HandleEntity handleEntity=new HandleEntity();
            handleEntity.setErrorHandleTime("");
            handleEntity.setHandleMessage(e.getMessage());
            handleEntity.setWhichThread(t.getName());
            sixHandleDao.insertSixHandle(handleEntity);
            //Intent intent=new Intent(mContext, RoomActivity.class);
            Process.killProcess(Process.myPid());
            System.exit(0);

        }

    }
}
