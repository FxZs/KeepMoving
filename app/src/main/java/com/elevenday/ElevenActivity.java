package com.elevenday;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cn.room.activity.R;
import com.elevenday.bean.ElevenLoginEntity;
import com.elevenday.presenter.EleventLoginPresent;
import com.elevenday.presenter.EleventLoginPresenterImp;
import com.elevenday.view.EleventLoginView;

/**
 * Created by Administrator on 2018/8/3.
 */

public class ElevenActivity extends AppCompatActivity implements EleventLoginView{
    private EleventLoginPresenterImp loginPresenterImp;
    private Button login_btn;
    private EditText eleventh_name,eleventh_pwd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.elevent_activity);
        loginPresenterImp=new EleventLoginPresenterImp(this);
        initView();
    }

    private void initView() {
        eleventh_name=findViewById(R.id.eleventh_name);
        eleventh_pwd=findViewById(R.id.eleventh_pwd);
        login_btn=findViewById(R.id.btn);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ElevenLoginEntity loginEntity=new ElevenLoginEntity();
                loginEntity.setUsername(eleventh_name.getText().toString());
                loginEntity.setUserpwd(eleventh_pwd.getText().toString());
                loginPresenterImp.doLogin(loginEntity);
            }
        });
    }

    @Override
    public void showLoginResult(String msg) {
             if(msg.equals("登陆成功")){
                 Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
             }else if(msg.equals("登陆失败")){
                 Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
             }
    }

    @Override
    public void setPresenter(EleventLoginPresent presenter) {

    }
}
