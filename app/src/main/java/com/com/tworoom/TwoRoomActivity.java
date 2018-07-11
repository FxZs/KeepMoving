package com.com.tworoom;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.cn.room.UserRoomDateSource;
import com.cn.room.activity.R;
import com.com.tworoom.presenter.Datapresenterimp;
import com.com.tworoom.source.MyUserLocaldatasource;
import com.com.tworoom.view.DataBaseAdapter;
import com.com.tworoom.view.DataView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by zhangpingzhen on 2018/7/11.
 */

public class TwoRoomActivity extends AppCompatActivity implements DataView{
    private TextView startdata,stopdata,alldata;
    private Datapresenterimp datapresenterimp;
    private RecyclerView recyclerView;
    private List<MyUser> lists=new ArrayList<>();
    private DataBaseAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tworoomactivity);//xml里面已经注册了  为啥这块没有它下面的R包
        initView();
        datapresenterimp=new Datapresenterimp(this);
    }

    private void initView() { //话说 view 不是应该放在fragment么？
        startdata=findViewById(R.id.starttime);
        stopdata=findViewById(R.id.stoptime);
        alldata=findViewById(R.id.counttime);
        recyclerView=findViewById(R.id.recyview);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        //设置RecyclerView 布局
        recyclerView.setLayoutManager(layoutManager);
        //设置Adapter
        adapter = new DataBaseAdapter(lists);
        recyclerView.setAdapter(adapter);

    }

//    @Override 这个不要了，你写你的 好 我断了 嗯
//    public MyUser getData() {
//        MyUser myUser = new MyUser();
//        myUser.setStartdata(Calendar.getInstance().getTime().toString());//时间就先这样写吧
//        return myUser;
//    }

//   // @Override
//    public void showData(MyUser time) {
//        /*startdata.setText(time.getStartdata());
//        stopdata.setText(time.getStopdata());*/
//
//         //下面一样 明白了，这个看实际需要的，（多考虑实际需要）
//        // 因为你要给多个控件赋值，且数据都在一个实体类里面，就没必要写三个接口，弄三个实现了
//
//    }

    @Override
    public void setPresenter(Object presenter) {

    }

    @Override //触发时间
    protected void onStart() {
        super.onStart();
        MyUser myUser=new MyUser();
        myUser.setStartdata("2018");
        myUser.setStopdata("2019");
        /*System.currentTimeMillis();*/
        datapresenterimp.totaltime(myUser);


    }

    @Override
    protected void onResume() {
        super.onResume();
        datapresenterimp.dudatashuju();
    }

    @Override //结束时间
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void showData(List<MyUser> time) {
        this.lists.clear();
        this.lists.addAll(time);
        adapter.notifyDataSetChanged();
    }
}
