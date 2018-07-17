package com.com.fiveday;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cn.room.activity.R;
import com.com.fiveday.adapter.ClickTimesAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangpingzhen on 2018/7/17.
 */

public class FiveActivity extends AppCompatActivity{
    private RecyclerView recyclerView;
    private List<HandleEntity> lists=new ArrayList<>();
    private ClickTimesAdapter clickAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newfive_activity);
        initView();

    }

    private void initView() {
        recyclerView=findViewById(R.id.newfivew_recy);
    }
}
