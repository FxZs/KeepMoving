package com.fx.keepmoving;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.fx.presenter.OnLoginpresentre;
import com.fx.view.LoginViewew;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,LoginViewew{
    private EditText username;
    private EditText userpwd;
    private Button loginbtn;
    private OnLoginpresentre onLoginpresentre;
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
    }

    private void initview() {
        username=findViewById(R.id.username);
        userpwd=findViewById(R.id.userpwd);
        loginbtn=findViewById(R.id.btn);
        loginbtn.setOnClickListener(this);
        onLoginpresentre=new OnLoginpresentre(this);
    }

    @Override
    public void onClick(View view) {
onLoginpresentre.Login();
    }

    @Override
    public String getUsername() {
        return username.getText().toString().trim();
    }

    @Override
    public String getPwd() {
        return userpwd.getText().toString().trim();
    }

    @Override
    public void ToastShow(String msg) {

    }
}
