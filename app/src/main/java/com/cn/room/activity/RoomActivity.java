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
import com.com.fiveday.FivewActivity;
import com.com.fourday.FourActivity;
import com.com.threeday.ThreeDataActivity;
import com.com.tworoom.TwoRoomActivity;
import com.sixday.SixActivity;


/**
 * Created by zhangpingzhen on 2018/7/10.
 */

public class RoomActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView starttime,stoptime,counttime;
     private PresenterImp presenterImp;
     private User user;
     private Button btnxiayibu,tworoombtn,threeroombtn,fourroombtn,fiveroombtn,sixBtn;
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

        tworoombtn=findViewById(R.id.Tworoombtn);
        threeroombtn=findViewById(R.id.Threeroombtn);
        fourroombtn=findViewById(R.id.Fourroombtn);
        fiveroombtn=findViewById(R.id.Fiveroombtn);
        sixBtn=findViewById(R.id.sixBtn);
        sixBtn.setOnClickListener(this);
        tworoombtn.setOnClickListener(this);
        threeroombtn.setOnClickListener(this);
        fourroombtn.setOnClickListener(this);
        fiveroombtn.setOnClickListener(this);
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


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Tworoombtn:
                String a =null;
                a.toCharArray();
                Intent intent=new Intent(RoomActivity.this,TwoRoomActivity.class);
                startActivity(intent);
                break;
            case R.id.Threeroombtn:
                Intent intenta=new Intent(RoomActivity.this,ThreeDataActivity.class);
                startActivity(intenta);
                break;
            case R.id.Fourroombtn:
                Intent intentb=new Intent(RoomActivity.this,FourActivity.class);
                startActivity(intentb);
                break;
            case R.id.Fiveroombtn:
                Intent intentc=new Intent(RoomActivity.this,FivewActivity.class);
                startActivity(intentc);
                break;
            case R.id.sixBtn:
                Intent intentd=new Intent(RoomActivity.this, SixActivity.class);
                startActivity(intentd);
                break;
        }
    }
}
