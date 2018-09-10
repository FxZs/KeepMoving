package com.sixday;

import android.app.ActivityManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;

import com.cn.room.activity.App;
import com.cn.room.activity.R;
import com.sixday.adapter.RetoAdapter;
import com.sixday.moudle.News;
import com.sixday.presenter.RetorPresenterImp;
import com.sixday.view.RetoView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/8/14.
 */

public class RetorActivity extends AppCompatActivity implements RetoView{
    private RecyclerView reto_recyview;
    private List<News> lists=new ArrayList<>();
    private RetorPresenterImp retorPresenterImp;
    RetoAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retor_activity);
        retorPresenterImp= new RetorPresenterImp(this,App.getRetorDatabase().retorDao());
//        WindowManager
//        ActivityManager
        reto_recyview=findViewById(R.id.reto_recyview);
        reto_recyview.setLayoutManager(new LinearLayoutManager(this));
       adapter=new RetoAdapter(lists, this);
        reto_recyview.setAdapter(adapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        retorPresenterImp.queryRetor();
    }

    @Override
    public void showRetorMsg(News  news) {
          lists.clear();
          lists.add(news);
          adapter.notifyDataSetChanged();
    }

    @Override
    public void setPresenter(Object presenter) {
     retorPresenterImp=(RetorPresenterImp) presenter;
    }
}
