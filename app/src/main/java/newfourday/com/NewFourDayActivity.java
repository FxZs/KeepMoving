package newfourday.com;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.cn.room.activity.App;
import com.cn.room.activity.R;
import com.com.fourday.dao.AccessTimeDao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import entity.AccessTimeEntity;
import newfourday.com.adapter.FourAccessAdapter;
import newfourday.com.presenter.FourPresenter;
import newfourday.com.presenter.FourPresenterImp;
import newfourday.com.view.FourView;

/**
 * Created by Administrator on 2018/9/12.
 */

public class NewFourDayActivity extends AppCompatActivity implements View.OnClickListener,FourView{
    private String nowTime;
    private String beforeFourTime;
    private Button new_insertaccess;
    long atime,btime;
    private String[] testName={"test1","test2","test3","test4","test5","test6"};
    private Context context;
    String testname,datetime;
    private RecyclerView recy_one;
    private FourAccessAdapter accessAdapter;
    private List<AccessTimeEntity> lists=new ArrayList<>();
    private FourPresenterImp fourPresenterImp;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fouractivity_main);
        context=this;
        initView();
    }

    private void initView() {
        new_insertaccess=findViewById(R.id.new_insertaccess);
        new_insertaccess.setOnClickListener(this);
        recy_one=findViewById(R.id.recy_one);
        recy_one.setLayoutManager(new LinearLayoutManager(this));
        accessAdapter=new FourAccessAdapter(lists,this);
        recy_one.setAdapter(accessAdapter);
        fourPresenterImp=new FourPresenterImp(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        AccessTimeEntity accessTimeEntity=new AccessTimeEntity();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
        Calendar c = Calendar.getInstance();
        System.out.println("当前日期："+sf.format(c.getTime()));
        nowTime=sf.format(c.getTime());
        accessTimeEntity.setStartTime(nowTime);
        SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
        Calendar cd = Calendar.getInstance();
        accessTimeEntity.setResurmTime(sfd.format(cd.getTime()));
        PackageManager packageManager=getPackageManager();
        try {
            PackageInfo info=packageManager.getPackageInfo(getPackageName(),0);
            String vision=info.versionName;
            accessTimeEntity.setPhoneType(vision);
            accessTimeEntity.setWhichSystem(vision);
            accessTimeEntity.setTotalTime("111100");
            Thread t = Thread.currentThread();
            accessTimeEntity.setThreadName(t.getName());
            accessTimeEntity.setWhichPage(context.getPackageName());
            int ai=0;
            double j=Math.random()*1000;//random（）生成0到1的随机数
            ai=((int)j)%testName.length;
            System.out.println("测试人员="+testName[ai]);
            accessTimeEntity.setWhichUser(testName[ai]);
            fourPresenterImp.insertFour(accessTimeEntity);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        fourPresenterImp.queryFour();
    }

    /**
     * 一个月几天？30
     * 一天几个小时？24
     * 一个小时多少分钟？60
     * 一分钟多少秒？60
     * 一秒多少毫秒？1000
     * 所以说 一天，一天，一天多少毫秒？写答案  24*60*60*1000=
     * 你要写的是4 月 到今天的随机数
     * 30 + 31 + 30 +31 +31 +14 四月 1 - 今天 的天数
     * 这些天的毫秒数是多少？写答案，人呢？不知道
     * （30 + 31 + 30 +31 +31 +14）* 24*60*60*1000 = x   你这写的是今天的吧
     * 四月1那天的毫秒值是多少？
     * System.currentTimeMillis() - x = y 起始那天的毫秒值
     * 接下来就是随机数了，
     *
     *
     * 说说你这样算下来  和我那个两个值 有啥区别？
     *
     *  rand.nextLong()  这个方法你看过么？这个方法只是随机生成一个long的 你继续呀，你没有办法去确定他的范围
     *
     *  这个求时间差随你怎么做就是一道简单的数学题
     *
     *  我只是在写我觉得效率最高的代码。嗯
     */
    private void Comparaent() {


        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        System.out.println("当前日期："+sf.format(c.getTime()));
        nowTime=sf.format(c.getTime());
        try {
            atime = sf.parse(sf.format(c.getTime())).getTime();//当前日期的毫秒值
            c.add(Calendar.DAY_OF_MONTH, -120);
            System.out.println("4个月前日期 ： "+sf.format(c.getTime()));
            beforeFourTime=sf.format(c.getTime());
            btime = sf.parse(sf.format(c.getTime())).getTime();//四个月前日期的毫秒值
            long re=atime-btime;
            Random rand = new Random();
            long chazhi=(long) (Math.random()*50)*1000;
            long suijishu =(long) (btime+Math.random()*re);//开始访问的随机数
            long startsuiji=suijishu+chazhi;//结束访问的随机数

            int ai=0;
            double j=Math.random()*1000;//random（）生成0到1的随机数
            ai=((int)j)%testName.length;
            System.out.println("测试人员="+testName[ai]);
        } catch (ParseException e) {
            e.printStackTrace();
        }



    }
    /**
     * 获取前n天日期、后n天日期
     *
     * @param distanceDay 前几天 如获取前7天日期则传-7即可；如果后7天则传7
     * @return
     */
    public static String getOldDate(int distanceDay) {
        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = new Date();
        Calendar date = Calendar.getInstance();
        date.setTime(beginDate);
        date.set(Calendar.DATE, date.get(Calendar.DATE) + distanceDay);
        Date endDate = null;
        try {
            endDate = dft.parse(dft.format(date.getTime()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //LogUtil.d("前7天==" + dft.format(endDate));
        Log.i("前7天==" , dft.format(endDate));
        return dft.format(endDate);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.new_insertaccess:
                //Comparaent();
                insertAccess();

                break;
        }
    }

    private void insertAccess() {


        AccessTimeEntity accessTimeEntity=new AccessTimeEntity();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
        Calendar c = Calendar.getInstance();
        System.out.println("当前日期："+sf.format(c.getTime()));
        nowTime=sf.format(c.getTime());
        accessTimeEntity.setStartTime(nowTime);
        SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
        Calendar cd = Calendar.getInstance();
        accessTimeEntity.setResurmTime(sfd.format(cd.getTime()));
        PackageManager packageManager=getPackageManager();
        try {
            PackageInfo info=packageManager.getPackageInfo(getPackageName(),0);
            String vision=info.versionName;
            accessTimeEntity.setPhoneType(vision);
            accessTimeEntity.setWhichSystem(vision);
            accessTimeEntity.setTotalTime("00");
            Thread t = Thread.currentThread();
            accessTimeEntity.setThreadName(t.getName());
            accessTimeEntity.setWhichPage(context.getPackageName());
            int ai=0;
            double j=Math.random()*1000;//random（）生成0到1的随机数
            ai=((int)j)%testName.length;
            System.out.println("测试人员="+testName[ai]);
            accessTimeEntity.setWhichUser(testName[ai]);
            fourPresenterImp.insertFour(accessTimeEntity);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void showMeg(List<AccessTimeEntity> accessTimeEntities) {
        lists.clear();
        lists.addAll(accessTimeEntities);
        accessAdapter.notifyDataSetChanged();
    }

    @Override
    public void setPresenter(FourPresenter presenter) {
        fourPresenterImp= (FourPresenterImp) presenter;
    }
}

