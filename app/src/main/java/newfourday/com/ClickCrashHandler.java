package newfourday.com;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.util.Log;
import android.widget.Toast;

import com.cn.room.activity.App;
import com.cn.room.activity.RoomActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import entity.HandleDealWithEntity;
import newfourday.com.dao.HandleDealWithDao;

/**
 * Created by zhangpingzhen on 2018/9/18.
 */

public class ClickCrashHandler implements Thread.UncaughtExceptionHandler{
    private static ClickCrashHandler sInstance = null;
    private Thread.UncaughtExceptionHandler mDefaultHandler;
    private Context mContext;
    private static String TAG="CrashHandler";
    private HandleDealWithDao dealWithDao;
    private String[] testName={"test1","test2","test3","test4","test5","test6","test7","test8","test9","test10","test11",
            "test12","test13","test14","test15","test16","test17","test18","test19","test20"};
    private String[]  phoneType={"android","ios"};
    private String[] whichStylem={"8.0","7.1.1","7.0","6.1.0","5.0","4.0"};

    public ClickCrashHandler(Context mContext) {
        this.mContext = mContext;
        this.dealWithDao= App.getFourdatabase().handleDealWithDao();
        // 获取默认异常处理器
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        // 将此类设为默认异常处理器
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(final Thread t,final Throwable e) {
        if (mDefaultHandler != null) {
//            mDefaultHandler.uncaughtException(t, e);
            e.printStackTrace();
            Log.e(TAG, t.getName() + "" + e.getLocalizedMessage());
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0;i<3000;i++){
                        HandleDealWithEntity dealWithEntity=new HandleDealWithEntity();
                        SimpleDateFormat sfa = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
                        Calendar c = Calendar.getInstance();
                        c.add(Calendar.DAY_OF_MONTH, -120);
                        long  btime = 0;//四个月前日期的毫秒值
                        try {
                            btime = sfa.parse(sfa.format(c.getTime())).getTime();
                        } catch (ParseException e1) {
                            e1.printStackTrace();
                        }
                        long re=System.currentTimeMillis()-btime;
                        long a =(long) (btime+Math.random()*re);
                        dealWithEntity.setHandleTime(sfa.format(new Date(a)));
                        dealWithEntity.setHandlePage(mContext.getPackageName());
                        dealWithEntity.setHanldeMethod(Thread.currentThread().getStackTrace().toString());
                        dealWithEntity.setWhichThread(t.getName());
                        dealWithEntity.setWhatHandle(Thread.currentThread().getName());
                        Random random = new Random();//创建随机对象
                        int len = testName.length;//获取数组长度给变量len
                        int arrIdx = random.nextInt(len);
                        dealWithEntity.setTestUser(testName[arrIdx]);
                        dealWithEntity.setPhoneType(phoneType[random.nextInt(phoneType.length)]);
                        dealWithEntity.setWhichSystem(whichStylem[random.nextInt(whichStylem.length)]);
                        dealWithEntity.setWhichCaozuo(e.getMessage());
                        dealWithDao.insertHandleDeal(dealWithEntity);
                    }
                }
            }).start();

        }
        Process.killProcess(Process.myPid());
        System.exit(0);

        Intent i = new Intent(mContext, RoomActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(i);
    }
}
