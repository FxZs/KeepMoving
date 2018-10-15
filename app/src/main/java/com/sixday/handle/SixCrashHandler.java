package com.sixday.handle;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.util.Log;

import com.cn.room.activity.App;
import com.cn.room.activity.RoomActivity;
import com.sixday.dao.SixHandleDao;
import com.sixday.moudle.HandleEntity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import newtenday.threefunction.dao.ThreeHandleDao;
import newtenday.threefunction.moundle.ThreeHandleEntity;

/**
 * Created by zhangpingzhen on 2018/7/19.
 * 就这个类  然后有异常的话  就闪退
 */

public class SixCrashHandler implements Thread.UncaughtExceptionHandler{
    private String[] user_name={"test01","test2","test3","test4","test5","test6","test7","test8","test9","test10"};
    private String[] phonesystem={"Android","IOS","Firefox OS","Windows Mobile","ubuntu","Sailfish OS","三星Tizen"};
    private String[] phonetype={"6.5.23","6.1.0","5.5.2","5.0.1","4.1.0","4.2.3","5.7.0","6.2.1"};
    private static com.com.fiveday.handle.CrashHandler sInstance = null;
    private Thread.UncaughtExceptionHandler mDefaultHandler;
    private Context mContext;
    private static String TAG="SixCrashHandler";
    private SixHandleDao sixHandleDao;
    private ThreeHandleDao threeHandleDao;
    public SixCrashHandler(Context context){

        this.mContext=context;
        sixHandleDao= App.getSixHandleBase().sixHandleDao();
        threeHandleDao= App.getNewTenDataBase().threeHandleDao();
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
           /* HandleEntity handleEntity=new HandleEntity();
            handleEntity.setErrorHandleTime("2018080808");
            handleEntity.setHandleMessage("0011211222");
            handleEntity.setWhichThread("030100000");
            sixHandleDao.insertSixHandle(handleEntity);*/
            ThreeHandleEntity threeHandleEntity=new ThreeHandleEntity();
            Random random=new Random();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
            threeHandleEntity.setTestUser(user_name[random.nextInt(10)]);
            threeHandleEntity.setPhoneType(phonetype[random.nextInt(8)]);
            threeHandleEntity.setWhichSystem(phonesystem[random.nextInt(7)]);
            threeHandleEntity.setHandlePage(mContext.getPackageName());
            threeHandleEntity.setWhichThread(Thread.currentThread().getName());
            threeHandleEntity.setHandleTime(sdf.format(new Date(System.currentTimeMillis())));
            threeHandleEntity.setWhatHandle(e.toString());
            threeHandleEntity.setHanldeMethod(t.getClass()+"");
            threeHandleDao.insertThreeHandle(threeHandleEntity);


        }
        Process.killProcess(Process.myPid());
        System.exit(0);

        Intent i = new Intent(mContext, RoomActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(i);
    }
}
