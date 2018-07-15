package com.com.fiveday;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.cn.room.activity.NoDoubleClickListener;
import com.cn.room.activity.R;
import com.com.fiveday.adapter.ClickTimesAdapter;
import com.com.fiveday.presenter.ClickPresentImp;
import com.com.fiveday.view.ClickView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Administrator on 2018/7/15.
 */

public class FivewActivity extends AppCompatActivity implements ClickView{
    private RecyclerView five_recyview;
    private ClickTimesAdapter clickAdapter;
    private ClickPresentImp  presentImp;
    private List<OnclickEntity>  lists=new ArrayList<>();
    private Button five_btn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.five_activity);
        initView();
        presentImp=new ClickPresentImp(this);
        clickAdapter=new ClickTimesAdapter(lists,this);
        five_recyview.setLayoutManager(new LinearLayoutManager(this));
        five_recyview.setAdapter(clickAdapter);
    }

    private void initView() {
        five_recyview=findViewById(R.id.five_recyview);
        five_btn=findViewById(R.id.five_btn);
        five_btn.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {

            }

            @Override
            protected void onCachClick(OnclickEntity entity) {
                entity.setDescribe("onCachClick");
                entity.setPagename(FivewActivity.class.getSimpleName());
                entity.setTimes(Calendar.getInstance().getTime().toString());
                entity.setText(five_btn.getText().toString());
                entity.setUsername("zs");
                presentImp.insertClickTime(entity);
            }


        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void showClickTimes(List<OnclickEntity> onclickEntities) {
           lists.clear();
           lists.addAll(onclickEntities);
           clickAdapter.notifyDataSetChanged();
    }

    @Override
    public void setPresenter(Object presenter) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        presentImp.queryClickTimes();
    }
}
