package com.sixday.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.cn.room.activity.R;
import com.sixday.adapter.SixHandleAdapter;
import com.sixday.moudle.HandleEntity;
import com.sixday.presenter.SixHandlePresenter;
import com.sixday.presenter.SixHandlePresenterImp;
import com.sixday.view.SixHandleView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangpingzhen on 2018/7/18.
 */

public class HandleFragment extends Fragment implements SixHandleView{
    private List<HandleEntity> lists=new ArrayList<>();
    private SixHandleAdapter handleAdapter;
    private SixHandlePresenterImp handlePresenterImp;
    private RecyclerView newfive_recy;
    private Context mContext;
    private Button fiev_bbttn;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view=  inflater.inflate(R.layout.newfive_activity,container,false);
       mContext=this.getActivity();
        newfive_recy=view.findViewById(R.id.newfive_recy);
        newfive_recy.setLayoutManager(new LinearLayoutManager(mContext));
        handleAdapter=new SixHandleAdapter(lists,mContext);
        newfive_recy.setAdapter(handleAdapter);
        //fiev_bbttn=view.findViewById(R.id.fiev_bbttn);
        fiev_bbttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           /* HandleEntity handleEntity=new HandleEntity();
            handleEntity.setErrorHandleTime("2019");
            handleEntity.setHandleMessage("00000");
            handleEntity.setWhichThread("main");
                handlePresenterImp.insertSixHandlePresenter(handleEntity);*/

            }
        });
        return view;
    }

    @Override
    public void showSixHandleView(List<HandleEntity> handleEntities) {
      lists.clear();
      lists.addAll(handleEntities);
      handleAdapter.notifyDataSetChanged();
    }

    @Override
    public void setPresenter(SixHandlePresenter presenter) {
        handlePresenterImp=(SixHandlePresenterImp) presenter;
    }
}
