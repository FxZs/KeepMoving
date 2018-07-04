package com.fx.keepmoving;

import android.content.Context;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.test.ActivityUnitTestCase;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fx.modle.User;
import com.fx.presenter.LoginPresenterImp;
import com.fx.presenter.OnLoginpresentre;
import com.fx.view.LoginViewew;

public class MainActivity extends AppCompatActivity{

    private Button btn;
    public  static final String TASK="asdadad";
private Context context;
    //2018年4月17日15:31:33
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //git测试2018年4月17日14:04:26s  客户端提交测试
        //Android 提交测试  Android本地提交测试
        //Android提交测试/***/
        //公司提交测试
        setContentView(R.layout.activity_main);
        context=this;
        initview();
        //初始化 present
        //需要改一个地方，LoginPresenterImp 也需要持有一个view实例，来调用showLoginResult 懂？嗯
        //有几种方法先说两个简单的
        //1.构造方法 2.set方法  这个是构造方法。懂了？嗯 set方法懂了？嗯 选一种就好
        //3.dragger2 这个后面在学
        //现在mvp已经完成90%
      //   presenter = new LoginPresenterImp(this);
         //什么时候调登录方法？
       /* loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //非空，正则就不写了
                User user = new User();
               user.setName(username.getText().toString());
                user.setPwd(userpwd.getText().toString());
                presenter.login(user);
            }
        });*/
        LoginFragment  loginFragment=(LoginFragment) getSupportFragmentManager().findFragmentById(R.id.login_fragment);
        if (loginFragment==null){
           loginFragment=LoginFragment.newInstance();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.login_fragment, loginFragment);
            transaction.commit();
        }
       new LoginPresenterImp(loginFragment);

    }

    private void initview() {

       btn=findViewById(R.id.btnlogin);//登录按钮点击事件里 嗯
btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

    }
});
    }



}
