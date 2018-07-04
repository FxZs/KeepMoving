package com.fx.keepmoving;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fx.modle.User;
import com.fx.presenter.LoginPresenterImp;
import com.fx.presenter.OnLoginpresentre;
import com.fx.view.LoginViewew;

public class MainActivity extends AppCompatActivity implements LoginContract.LoginView{
    private EditText username;
    private EditText userpwd;
    private Button loginbtn;
    private LoginPresenterImp presenter;

    //2018年4月17日15:31:33
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //git测试2018年4月17日14:04:26s  客户端提交测试
        //Android 提交测试  Android本地提交测试
        //Android提交测试/***/
        //公司提交测试
        setContentView(R.layout.activity_main);
        initview();
        //初始化 present
        //需要改一个地方，LoginPresenterImp 也需要持有一个view实例，来调用showLoginResult 懂？嗯
        //有几种方法先说两个简单的
        //1.构造方法 2.set方法  这个是构造方法。懂了？嗯 set方法懂了？嗯 选一种就好
        //3.dragger2 这个后面在学
        //现在mvp已经完成90%
         presenter = new LoginPresenterImp(this);
         //什么时候调登录方法？
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //非空，正则就不写了
                User user = new User();
               user.setName(username.getText().toString());
                user.setPwd(userpwd.getText().toString());
                presenter.login(user);
            }
        });
    }

    private void initview() {
        username=findViewById(R.id.username);
        userpwd=findViewById(R.id.userpwd);
        loginbtn=findViewById(R.id.btn);//登录按钮点击事件里 嗯

    }


    @Override
    public void setPresenter(LoginContract.LoginPresenter presenter) {
        //这个没用到要不要给你解释下
    }

    @Override
    public void showLoginResult(String result) {//这个方法里面不需要再写其他的了  错误的提示也都写在刚才那里
        //这个result就是你判断之后返回给view 让view展示给用户的
        //然后这里被调用，可以toast，dialog 页面跳转之类的 就写完了
        //现在这个result 就是 "成功"，你toast 这个字符串就好了
        Toast.makeText(this,result,Toast.LENGTH_LONG).show();//就这样了
    }
}
