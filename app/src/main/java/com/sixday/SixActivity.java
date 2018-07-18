package com.sixday;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cn.room.activity.R;
import com.sixday.fragment.AccessTimeFragment;
import com.sixday.fragment.ClicksNumberFragment;
import com.sixday.fragment.HandleFragment;

/**
 * Created by zhangpingzhen on 2018/7/18.
 */

public class SixActivity extends FragmentActivity implements View.OnClickListener{
    // 底部菜单3个Linearlayout
    private LinearLayout six_accetime;
    private LinearLayout six_clicknumber;
    private LinearLayout six_handle;

    // 底部菜单3个菜单标题
    private TextView tv_accetime;
    private TextView tv_clicknumber;
    private TextView tv_handle;

    // 3个Fragment
    private Fragment accessFragment;
    private Fragment clickFragemet;
    private Fragment handleFragment;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.six_activity);
        // 初始化控件
        initView();

        // 初始化并设置当前Fragment
        initFragment(0);
    }
    private void initView() {
        // 底部菜单4个Linearlayout
        six_accetime = (LinearLayout) findViewById(R.id.ll_home);
        six_clicknumber = (LinearLayout) findViewById(R.id.ll_address);
        six_handle = (LinearLayout) findViewById(R.id.ll_friend);
        six_accetime.setOnClickListener(this);
        six_clicknumber.setOnClickListener(this);
        six_handle.setOnClickListener(this);
        // 底部菜单4个菜单标题
        tv_accetime = (TextView) findViewById(R.id.tv_home);
        tv_clicknumber = (TextView) findViewById(R.id.tv_address);
        tv_handle = (TextView) findViewById(R.id.tv_friend);
    }
    private void initFragment(int index) {
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        // 隐藏所有Fragment
        hideFragment(transaction);
        switch (index){
            case 0:
                if (accessFragment==null){
                    accessFragment=new AccessTimeFragment();
                    transaction.add(R.id.fl_content,accessFragment);
                }else {
                    transaction.show(accessFragment);
                }
                break;
            case 1:
                if (clickFragemet==null){
                    clickFragemet=new ClicksNumberFragment();
                    transaction.add(R.id.fl_content,clickFragemet);
                }else {
                    transaction.show(clickFragemet);
                }
                break;
            case 2:
                if (handleFragment==null){
                    handleFragment=new HandleFragment();
                    transaction.add(R.id.fl_content,handleFragment);
                }else {
                    transaction.show(handleFragment);
                }
                break;
        }
        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction) {
        if (accessFragment!=null){
            transaction.hide(accessFragment);
        }
        if (clickFragemet!=null){
            transaction.hide(clickFragemet);
        }
        if (handleFragment!=null){
            transaction.hide(handleFragment);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_home:
                tv_accetime.setTextColor(0xff1B940A);
                tv_clicknumber.setTextColor((this.getResources().getColor(R.color.colorPrimary)));
                tv_handle.setTextColor((this.getResources().getColor(R.color.colorPrimary)));
                initFragment(0);
                break;
            case R.id.ll_address:
                tv_clicknumber.setTextColor(0xff1B940A);
                tv_accetime.setTextColor((this.getResources().getColor(R.color.colorPrimary)));
                tv_handle.setTextColor((this.getResources().getColor(R.color.colorPrimary)));
                initFragment(1);
                break;
            case R.id.ll_friend:
                tv_handle.setTextColor(0xff1B940A);
                tv_clicknumber.setTextColor((this.getResources().getColor(R.color.colorPrimary)));
                tv_accetime.setTextColor((this.getResources().getColor(R.color.colorPrimary)));
                initFragment(2);
                break;
        }
    }
}
