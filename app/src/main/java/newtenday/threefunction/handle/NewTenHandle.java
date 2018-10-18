package newtenday.threefunction.handle;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.support.annotation.Nullable;
import android.util.Log;

import com.cn.room.activity.App;
import com.cn.room.activity.RoomActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import newtenday.threefunction.dao.ThreeHandleDao;
import newtenday.threefunction.moundle.ThreeHandleEntity;
import newtenday.threefunction.presenter.ThreeHandleNetServlet;

/**
 * Created by zhangpingzhen on 2018/10/15.
 */

public class NewTenHandle implements Thread.UncaughtExceptionHandler {
    private Context context;
    private ThreeHandleDao threeHandleDao;
    private Thread.UncaughtExceptionHandler mDefaultHandler;
    private static String TAG="NewTenHandle";
    private String[] user_name={"test01","test2","test3","test4","test5","test6","test7","test8","test9","test10"};
    private String[] phonesystem={"Android","IOS","Firefox OS","Windows Mobile","ubuntu","Sailfish OS","三星Tizen"};
    private String[] phonetype={"6.5.23","6.1.0","5.5.2","5.0.1","4.1.0","4.2.3","5.7.0","6.2.1"};
    private ThreeHandleNetServlet threeHandleNetServlet;
    public NewTenHandle(Context context) {
        this.context = context;
        threeHandleDao= App.getNewTenDataBase().threeHandleDao();
        mDefaultHandler=Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
        threeHandleNetServlet=new ThreeHandleNetServlet();
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
           if(mDefaultHandler!=null){
               Log.e(TAG,e.getMessage());
              new Thread(new Runnable() {
                  @Override
                  public void run() {
                      ThreeHandleEntity threeHandleEntity=new ThreeHandleEntity();
                      Random random=new Random();
                      SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
                      threeHandleEntity.setTestUser(user_name[random.nextInt(10)]);
                      threeHandleEntity.setPhoneType(phonetype[random.nextInt(8)]);
                      threeHandleEntity.setWhichSystem(phonesystem[random.nextInt(7)]);
                      threeHandleEntity.setHandlePage(context.getPackageName());
                      threeHandleEntity.setWhichThread(Thread.currentThread().getName());
                      threeHandleEntity.setHandleTime(sdf.format(new Date(System.currentTimeMillis())));
                      threeHandleEntity.setWhatHandle(e.getMessage());
                      threeHandleEntity.setHanldeMethod(t.getClass()+"");
                      threeHandleDao.insertThreeHandle(threeHandleEntity);
                      threeHandleNetServlet.insertThreeHandlePresenter(threeHandleEntity);
                  }
              }).start();
           }
        Process.killProcess(Process.myPid());
        System.exit(0);

        Intent i = new Intent(context, RoomActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }
}
