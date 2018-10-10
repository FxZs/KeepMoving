package com.cn.room.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
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
import com.elevenday.ElevenActivity;
import com.sixday.RetorActivity;
import com.sixday.SixActivity;

import designoneday.DesignActivity;
import designoneday.TextViewActivity;
import newday.com.MainActivityNewDay;
import newfourday.com.NewFourDayActivity;
import newtenday.LoginActivity;
import rxjavalian.RxJavaTest;
import rxjavalian.entity.GetRequest;


/**
 * Created by zhangpingzhen on 2018/7/10.
 */

public class RoomActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView starttime,stoptime,counttime;
     private PresenterImp presenterImp;
     private User user;
     private Button btnxiayibu,tworoombtn,threeroombtn,fourroombtn,fiveroombtn,
             sixBtn,eleventBtn,retoBtn,interBtn,newFourBtn,design_btn,textview_btn,ten_btn;
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

        tworoombtn=findViewById(R.id.Tworoombtn);
        threeroombtn=findViewById(R.id.Threeroombtn);
        fourroombtn=findViewById(R.id.Fourroombtn);
        fiveroombtn=findViewById(R.id.Fiveroombtn);
        retoBtn=findViewById(R.id.retoBtn);
        retoBtn.setOnClickListener(this);
        interBtn=findViewById(R.id.interBtn);
        interBtn.setOnClickListener(this);
        sixBtn=findViewById(R.id.sixBtn);
        sixBtn.setOnClickListener(this);
        eleventBtn=findViewById(R.id.eleventBtn);
        eleventBtn.setOnClickListener(this);
        tworoombtn.setOnClickListener(this);
        threeroombtn.setOnClickListener(this);
        fourroombtn.setOnClickListener(this);
        fiveroombtn.setOnClickListener(this);
        newFourBtn=findViewById(R.id.newFourBtn);
        newFourBtn.setOnClickListener(this);
        design_btn=findViewById(R.id.design_btn);
        design_btn.setOnClickListener(this);
        textview_btn=findViewById(R.id.textview_btn);
        textview_btn.setOnClickListener(this);
        ten_btn=findViewById(R.id.ten_btn);
        ten_btn.setOnClickListener(this);
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
               /* String a =null;
                a.toCharArray();*/
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
            case R.id.eleventBtn:
                Intent intentaa=new Intent(RoomActivity.this, ElevenActivity.class);
                startActivity(intentaa);
                break;
            case R.id.retoBtn:
                Intent intentab=new Intent(RoomActivity.this, RetorActivity.class);
                startActivity(intentab);
                break;
            case R.id.interBtn:
                Intent intentac=new Intent(RoomActivity.this, MainActivityNewDay.class);
                startActivity(intentac);
                break;
            case R.id.newFourBtn:
                Intent intentad=new Intent(RoomActivity.this, NewFourDayActivity.class);
                startActivity(intentad);
                break;
            case R.id.design_btn:
                Intent intentae=new Intent(RoomActivity.this, DesignActivity.class);
                startActivity(intentae);
                break;
            case R.id.textview_btn:
                //Intent intentaf=new Intent(RoomActivity.this, TextViewActivity.class);
                Intent intentaf=new Intent(RoomActivity.this, GetRequest.class);
                startActivity(intentaf);
                break;
            case R.id.ten_btn:
                //Intent intentaf=new Intent(RoomActivity.this, TextViewActivity.class);
                Intent intentah=new Intent(RoomActivity.this, LoginActivity.class);
                startActivity(intentah);
                break;

        }
    }
}
