package com.sevenday;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.cn.room.activity.R;
import com.sevenday.modle.LoginEntity;
import com.sevenday.presenter.SenvenLoginPresenter;
import com.sevenday.presenter.SenvenLoginPresenterImp;
import com.sevenday.view.SenvenLoginView;

/**
 * Created by zhangpingzhen on 2018/7/20.
 */

public class SenvenActivity extends AppCompatActivity implements SenvenLoginView{
    private TextView senven_name,senven_pwd;
    private TextView senven_btn;
    private SenvenLoginPresenterImp senvenLoginPresenterImp;
    private Context context;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.senven_loginactivity);
        context=this;
        initView();
        senvenLoginPresenterImp=new SenvenLoginPresenterImp(this);
    }

    private void initView() {
        senven_btn=findViewById(R.id.senven_btn);
        senven_name=findViewById(R.id.senven_name);
        senven_pwd=findViewById(R.id.senven_pwd);
        senven_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginEntity loginEntity=new LoginEntity();
                loginEntity.setUsername(senven_name.getText().toString());
                loginEntity.setUserpwd(senven_pwd.getText().toString());
                senvenLoginPresenterImp.Login(loginEntity);
            }
        });
    }
    @Override
    public void setPresenter(SenvenLoginPresenter presenter) {
        senvenLoginPresenterImp=(SenvenLoginPresenterImp) presenter;
    }

    @Override
    public void showLoginResult(String msg) {

    }
}
