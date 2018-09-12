package newthreeday.com.handle;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.util.Log;

import com.cn.room.activity.App;
import com.cn.room.activity.RoomActivity;
import com.sixday.dao.SixHandleDao;

import newthreeday.com.dao.CatchHandleDao;
import newthreeday.com.moudle.CatchHandleEntity;

/**
 * Created by zhangpingzhen on 2018/9/12.
 */

public class CrashHandler  implements Thread.UncaughtExceptionHandler{
    private static CrashHandler sInstance = null;
    private Thread.UncaughtExceptionHandler mDefaultHandler;
    private Context mContext;
    private static String TAG="CrashHandler";
    private CatchHandleDao catchHandleDao;

    public CrashHandler(Context mContext) {
        this.mContext = mContext;
        this.catchHandleDao= App.getRetorDatabase().catchHandleDao();
        // 获取默认异常处理器
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        // 将此类设为默认异常处理器
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        if (mDefaultHandler != null) {
//            mDefaultHandler.uncaughtException(t, e);
            Log.e(TAG, t.getName() + "" + e.getLocalizedMessage());
            CatchHandleEntity catchHandleEntity=new CatchHandleEntity();
            catchHandleEntity.setCatchTime(System.currentTimeMillis()+"");
            catchHandleEntity.setWhichMethod(t.getName());
            catchHandleEntity.setWhatHandle(e.getMessage());
            catchHandleEntity.setAndroidos("安卓");
            catchHandleEntity.setPhoneType("7.1.1");
            catchHandleEntity.setWhichUse("测试人员");
            catchHandleDao.insertCatchHandle(catchHandleEntity);
        }
        Process.killProcess(Process.myPid());
        System.exit(0);

        Intent i = new Intent(mContext, RoomActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(i);
    }
}
