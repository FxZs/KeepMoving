package com.sixday.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cn.room.activity.R;
import com.sixday.adapter.SixAccessAdapter;
import com.sixday.moudle.AccessEntity;
import com.sixday.presenter.SixAccessPresenter;
import com.sixday.presenter.SixAccessPresenterImp;
import com.sixday.view.SixAccessView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangpingzhen on 2018/7/18.
 */

public class AccessTimeFragment extends Fragment implements SixAccessView{
    private RecyclerView recyview;
    private Context mContext;
    private List<AccessEntity> lists=new ArrayList<>();
    private SixAccessPresenterImp sixPresenterImp;
    private SixAccessAdapter adapter;
    private String TAG = AccessTimeFragment.class.getName();
    @Nullable


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.tworoomactivity,container,false);
        mContext=this.getActivity();
        recyview=view.findViewById(R.id.recyview);
        recyview.setLayoutManager(new LinearLayoutManager(mContext));
        adapter=new SixAccessAdapter(lists,mContext);
        recyview.setAdapter(adapter);
        Log.i(TAG,"onCreateView");
        return view;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG,"onCreate");
    }

    @Override
    public void onStart() {//页面生命周期调用，
        super.onStart();

        Log.i(TAG,"onStart");
        AccessEntity accessEntity=new AccessEntity();
        accessEntity.setStartdata("23556562");
        accessEntity.setPausedata("58997874");
        sixPresenterImp.insertAccessPresenter(accessEntity);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG,"onResume");
        sixPresenterImp.queryAccessPresenter();
    }

    @Override
    public void onPause() {//你写在这里不就是让暂停的时候查询数据库么看清楚了么？ 看生命周期？这个知道   知道你把查询显示的方法放在onPause还问我怎么离开这个界面了才有数据？
        super.onPause();
        Log.i(TAG,"onPause");
    }

    @Override
    public void showSixAccessView(List<AccessEntity> accessEntities) {
        lists.clear();
        lists.addAll(accessEntities);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void setPresenter(SixAccessPresenter presenter) {
        this.sixPresenterImp=(SixAccessPresenterImp) presenter;
    }
}
