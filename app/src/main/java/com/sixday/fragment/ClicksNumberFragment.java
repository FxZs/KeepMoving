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

import com.cn.room.activity.NoDoubleClickListener;
import com.cn.room.activity.R;
import com.com.fiveday.OnclickEntity;
import com.sixday.adapter.SixClickAdapter;
import com.sixday.moudle.ClickEntity;
import com.sixday.presenter.SixClickNumberPresenter;
import com.sixday.presenter.SixClickNumberPresenterImp;
import com.sixday.view.SixClickNumberView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by zhangpingzhen on 2018/7/18.
 */

public class ClicksNumberFragment extends Fragment implements SixClickNumberView{
    private List<ClickEntity> entityList=new ArrayList<>();
    private Context mContext;
    private RecyclerView five_recyview;
    private Button five_btn;
    private SixClickAdapter clickAdapter;
    private SixClickNumberPresenterImp sixClickNPImp;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.five_activity,container,false);
       mContext=this.getActivity();
        five_recyview=view.findViewById(R.id.five_recyview);
        five_btn=view.findViewById(R.id.five_btn);
        five_recyview.setLayoutManager(new LinearLayoutManager(mContext));
        clickAdapter=new SixClickAdapter(entityList,mContext);
        five_recyview.setAdapter(clickAdapter);
        five_btn.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onSixClickCach(ClickEntity clickEntity) {
                clickEntity.setClickBtnTime(Calendar.getInstance().getTime().toString());
                clickEntity.setBtnNextDecriber("onSixClickCach");
                clickEntity.setClickBtnText(five_btn.getText().toString());

                sixClickNPImp.insertSixClickNumberPresenter(clickEntity);
            }

            @Override
            protected void onNoDoubleClick(View v) {

            }

            @Override
            protected void onCachClick(OnclickEntity entity) {

            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        sixClickNPImp.querySixClickNumberPresenter();
    }

    @Override
    public void showSixClickNumberView(List<ClickEntity> clickEntities) {
              entityList.clear();
              entityList.addAll(clickEntities);
              clickAdapter.notifyDataSetChanged();
    }

    @Override
    public void setPresenter(SixClickNumberPresenter presenter) {
       sixClickNPImp=(SixClickNumberPresenterImp) presenter;
    }
}
