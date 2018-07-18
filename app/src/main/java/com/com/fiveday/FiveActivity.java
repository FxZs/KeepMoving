package com.com.fiveday;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.cn.room.activity.R;
import com.com.fiveday.adapter.HandleAdapter;
import com.com.fiveday.presenter.HandlePresentImp;
import com.com.fiveday.view.HandleView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangpingzhen on 2018/7/17.
 */

public class FiveActivity extends AppCompatActivity implements HandleView{
    private RecyclerView newfive_recy;
    private List<HandleEntity> entityList=new ArrayList<>();
    private HandleAdapter handleAdapter;
    private HandlePresentImp handlePresentImp;
    private Button fiev_bbttn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newfive_activity);
        initView();
        handlePresentImp=new HandlePresentImp(this);
        newfive_recy.setLayoutManager(new LinearLayoutManager(this));
        handleAdapter=new HandleAdapter();
        newfive_recy.setAdapter(handleAdapter);
    }

    private void initView() {
        newfive_recy=findViewById(R.id.newfive_recy);
        //fiev_bbttn=findViewById(R.id.fiev_bbttn);
        fiev_bbttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HandleEntity handleEntity=new HandleEntity();
                handleEntity.setHandleMessage("错误内容");
                handleEntity.setErrorTimes("2017");
                handleEntity.setWhichThread("main");
                handlePresentImp.insertHandlePresenter(handleEntity);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void ShowWhatHandle(List<HandleEntity> handleEntities) {
        entityList.clear();
        entityList.addAll(handleEntities);
        handleAdapter.notifyDataSetChanged();
    }

    @Override
    public void setPresenter(Object presenter) {

    }
}
