package com.sixday.handle;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.util.Log;

import com.cn.room.activity.App;
import com.cn.room.activity.RoomActivity;
import com.sixday.dao.SixHandleDao;
import com.sixday.moudle.HandleEntity;

/**
 * Created by zhangpingzhen on 2018/7/19.
 * 就这个类  然后有异常的话  就闪退
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
//            mDefaultHandler.uncaughtException(t, e); 你这里不是把异常数据插入到数据库了么  也查了
            Log.e(TAG,t.getName()+""+e.getLocalizedMessage());
            HandleEntity handleEntity=new HandleEntity();
            handleEntity.setErrorHandleTime("");
            handleEntity.setHandleMessage(e.getMessage());
            handleEntity.setWhichThread(t.getName());
            sixHandleDao.insertSixHandle(handleEntity);


        }
        Process.killProcess(Process.myPid());
        System.exit(0);

        Intent i = new Intent(mContext, RoomActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(i);
    }
}
