package newfourday.com;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.cn.room.activity.App;
import com.cn.room.activity.R;
import com.com.fourday.dao.AccessTimeDao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import entity.AccessTimeEntity;
import entity.ClickListerEntity;
import entity.HandleDealWithEntity;
import newfourday.com.adapter.FourAccessAdapter;
import newfourday.com.dao.ClickListerDao;
import newfourday.com.presenter.FourPresenter;
import newfourday.com.presenter.FourPresenterImp;
import newfourday.com.view.FourView;

/**
 * Created by Administrator on 2018/9/12.
 */

public class NewFourDayActivity extends AppCompatActivity implements View.OnClickListener,FourView{
    private String nowTime;
    private String beforeFourTime;
    private Button new_insertaccess,new_onclickbtn,new_headbtn,new_httpbtn;
    long atime,btime;
    private String[] testName={"test1","test2","test3","test4","test5","test6","test7","test8","test9","test10","test11",
    "test12","test13","test14","test15","test16","test17","test18","test19","test20"};
    private Context context;
    String testname,datetime;
    private RecyclerView recy_one;
    private FourAccessAdapter accessAdapter;
    private List<AccessTimeEntity> lists=new ArrayList<>();
    private FourPresenterImp fourPresenterImp;
    private ClickListerDao clickListerDao;
    String DATABASE_NAME = "four.db";

    String oldPath = "data/data/com.fx.keepmoving/databases/" + DATABASE_NAME;
    String newPath = Environment.getExternalStorageDirectory() + File.separator + DATABASE_NAME;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fouractivity_main);
        clickListerDao=App.getFourdatabase().clickListerDao();
        context=this;
        initView();

    }

    public static void copyFile(String oldPath, String newPath) {
        try {
            int bytesum = 0;
            int byteread = 0;
            File oldfile = new File(oldPath);
            File newfile = new File(newPath);
            if (!newfile.exists()) {
                newfile.createNewFile();
            }
            if (oldfile.exists()) { // 文件存在时
                InputStream inStream = new FileInputStream(oldPath); // 读入原文件
                FileOutputStream fs = new FileOutputStream(newPath);
                byte[] buffer = new byte[1444];
                while ((byteread = inStream.read(buffer)) != -1) {
                    bytesum += byteread; // 字节数 文件大小
                    fs.write(buffer, 0, byteread);
                }
                inStream.close();
            }
        } catch (Exception e) {
            System.out.println("复制单个文件操作出错");
            e.printStackTrace();
        }
    }


    private void initView() {
        new_insertaccess=findViewById(R.id.new_insertaccess);
        new_insertaccess.setOnClickListener(this);
        recy_one=findViewById(R.id.recy_one);
        recy_one.setLayoutManager(new LinearLayoutManager(this));
        accessAdapter=new FourAccessAdapter(lists,this);
        recy_one.setAdapter(accessAdapter);
        fourPresenterImp=new FourPresenterImp(this);
        new_onclickbtn=findViewById(R.id.new_onclickbtn);
        new_onclickbtn.setOnClickListener(this);
        new_headbtn=findViewById(R.id.new_headbtn);
        new_headbtn.setOnClickListener(this);
        new_httpbtn=findViewById(R.id.new_httpbtn);
        new_httpbtn.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();
       // fourPresenterImp.queryFour();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.new_insertaccess:
                insertAccess();
                copyFile(oldPath,newPath);
                break;
            case R.id.new_onclickbtn:
                ClickListerEntity clickListerEntity=new ClickListerEntity();
                SimpleDateFormat sfa = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
                Calendar c = Calendar.getInstance();
                clickListerEntity.setWhatClickTime(sfa.format(c.getTime()));
                clickListerEntity.setBtnText(new_onclickbtn.getText().toString());
                clickListerEntity.setWhichPage(context.getPackageName());
                clickListerEntity.setWhichThread(Thread.currentThread().getName().toString());
                int aib=0;
                double jb=Math.random()*1000;//random（）生成0到1的随机数
                aib=((int)jb)%testName.length;
                clickListerEntity.setTestUser(testName[aib]);
                try {
                    PackageInfo info=getPackageManager().getPackageInfo(getPackageName(),0);
                    clickListerEntity.setPhoneType(info.versionName);
                    clickListerEntity.setWhichSystem(info.versionName);
                    clickListerEntity.setWhereBtn(new_onclickbtn.getPrivateImeOptions());
                    clickListerEntity.setWhichMethod(Thread.currentThread().getStackTrace().toString());
                    clickListerDao.insertClickLister(clickListerEntity);
                    System.out.print("click插入数据库成功");
                    Toast.makeText(context,"click数据插入数据库成功",Toast.LENGTH_LONG).show();
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.new_headbtn:
                String a=null;
                a.charAt(0);
                break;
            case R.id.new_httpbtn:
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
            accessTimeEntity.setPhoneType(info.versionName);
            accessTimeEntity.setWhichSystem(info.versionName);
            accessTimeEntity.setTotalTime("111100");
            accessTimeEntity.setThreadName(Thread.currentThread().getName());
            accessTimeEntity.setWhichPage(context.getPackageName());
            Random random = new Random();//创建随机对象
            int len = testName.length;//获取数组长度给变量len
            int arrIdx = random.nextInt(len);//随机数组索引，nextInt(len-1)表示随机整数[0,(len-1)]之间的值
            System.out.println("测试人员="+testName[arrIdx]);
            accessTimeEntity.setWhichUser(testName[arrIdx]);
            fourPresenterImp.insertFour(accessTimeEntity);
            Toast.makeText(this,"插入acess数据成功",Toast.LENGTH_LONG).show();

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

