package com.com.fourday;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.cn.room.activity.NoDoubleClickListener;
import com.cn.room.activity.R;
import com.com.fiveday.FivewActivity;
import com.com.fiveday.presenter.ClickPresentImp;
import com.com.fourday.adapter.AccessTimeAdapter;
import com.com.fourday.presenter.AccessPresenterImp;
import com.com.fourday.view.AccessView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangpingzhen on 2018/7/12.  恭喜你   还没写对。。哎
 */

public class FourActivity extends AppCompatActivity implements AccessView{
    private List<AccessTime>  list=new ArrayList<>();
    private AccessPresenterImp  accessPresenterImp;
    private RecyclerView recyclerView;
    private AccessTimeAdapter mAdapter;
    private Button four_btn;
    private ClickPresentImp clickPresentImp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.four_activity);
        initView();
        new AccessPresenterImp(this);
        mAdapter=new AccessTimeAdapter(list,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mAdapter);

    }

    private void initView() {
        recyclerView=findViewById(R.id.four_recy);
        four_btn=findViewById(R.id.four_btn);

    }

    @Override
    public void showAccessTime(List<AccessTime> accessTimes) {
        accessTimes.clear();
        accessTimes.addAll(list);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void setPresenter(Object presenter) {
        this.accessPresenterImp=(AccessPresenterImp) presenter;
    }

    @Override
    protected void onStart() {
        super.onStart();
        AccessTime accTime=new AccessTime();
        accTime.setStartAccess("5555");
        accTime.setStopAccess("666");
        accessPresenterImp.manageAccessData(accTime);
    }

    @Override
    protected void onResume() {
        super.onResume();
        accessPresenterImp.fetchAccessData();
    }
}
