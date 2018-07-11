package com.cn.room.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cn.room.User;
import com.cn.room.UserRoomDateSource;
import com.cn.room.presenter.PresenterImp;
import com.cn.room.presenter.UserPresenter;
import com.cn.room.view.UserView;
import com.com.tworoom.TwoRoomActivity;


/**
 * Created by zhangpingzhen on 2018/7/10.
 */

public class RoomActivity extends AppCompatActivity {
    private TextView starttime,stoptime,counttime;
     private PresenterImp presenterImp;
     private User user;
     private Button btnxiayibu;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roomactivity);
        initView();
        user = new User();
        user.setStarttime("2017");
        user.setStoptime("2018");
        user.setCounttime("20");
        presenterImp=new PresenterImp();

    }

    private void initView() {
        starttime=findViewById(R.id.starttime);
        stoptime=findViewById(R.id.stoptime);
        counttime=findViewById(R.id.counttime);
        btnxiayibu=findViewById(R.id.btnxiayibu);
        btnxiayibu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RoomActivity.this,TwoRoomActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenterImp.starttime(user);

    }

    @Override
    protected void onStop() {
        super.onStop();
        presenterImp.stoptime(user);

    }


}
