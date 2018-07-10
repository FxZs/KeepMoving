package com.fx.keepmoving;

import android.app.FragmentTransaction;
import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fx.modle.User;
import com.fx.presenter.HyDatabase;
import com.fx.presenter.LoginPresenterImp;
import com.fx.presenter.OnLoginpresentre;
import com.fx.view.LoginViewew;

public class MainActivity extends AppCompatActivity {

    private Button fbtn;
    private LoginPresenterImp presenter;

    //2018年4月17日15:31:33
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //git测试2018年4月17日14:04:26s  客户端提交测试
        //Android 提交测试  Android本地提交测试
        //Android提交测试/***/
        //公司提交测试
        //setContentView(R.layout.login_fragment);
        initview();
      //  LoginFragment loginFragment= (LoginFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        /*if (loginFragment==null){
            loginFragment=new LoginFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
            //fragmentTransaction.add(R.id.fragment,loginFragment);
            fragmentTransaction.commit();
        }
        new LoginPresenterImp(loginFragment);*/
        //初始化 present
        //需要改一个地方，LoginPresenterImp 也需要持有一个view实例，来调用showLoginResult 懂？嗯
        //有几种方法先说两个简单的
        //1.构造方法 2.set方法  这个是构造方法。懂了？嗯 set方法懂了？嗯 选一种就好
        //3.dragger2 这个后面在学
        //现在mvp已经完成90%
       /*  presenter = new LoginPresenterImp(this);*/
         //什么时候调登录方法？
        HyDatabase database= Room.databaseBuilder(this,HyDatabase.class,"room.db").build();


    }

    private void initview() {

       // fbtn=findViewById(R.id.frbtn);//登录按钮点击事件里 嗯

    }



}
