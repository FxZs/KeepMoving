package com.com.tworoom;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.cn.room.UserRoomDateSource;
import com.cn.room.activity.R;
import com.com.tworoom.presenter.Datapresenterimp;
import com.com.tworoom.source.MyUserLocaldatasource;
import com.com.tworoom.view.DataView;

import java.util.Calendar;

/**
 * Created by zhangpingzhen on 2018/7/11.
 */

public class TwoRoomActivity extends AppCompatActivity implements DataView{
private TextView startdata,stopdata,alldata;
private Datapresenterimp datapresenterimp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tworoomactivity);//xml里面已经注册了  为啥这块没有它下面的R包
initView();
datapresenterimp=new Datapresenterimp();

    }

    private void initView() { //话说 view 不是应该放在fragment么？
        startdata=findViewById(R.id.starttime);
        stopdata=findViewById(R.id.stoptime);
        alldata=findViewById(R.id.counttime);
    }

//    @Override 这个不要了，你写你的 好 我断了 嗯
//    public MyUser getData() {
//        MyUser myUser = new MyUser();
//        myUser.setStartdata(Calendar.getInstance().getTime().toString());//时间就先这样写吧
//        return myUser;
//    }

    @Override
    public void showData(MyUser time) {
        startdata.setText(time.getStartdata());
        //下面一样 明白了，这个看实际需要的，（多考虑实际需要）
        // 因为你要给多个控件赋值，且数据都在一个实体类里面，就没必要写三个接口，弄三个实现了
    }

    @Override
    public void setPresenter(Object presenter) {

    }

    @Override //触发时间
    protected void onStart() {
        super.onStart();


    }

    @Override //结束时间
    protected void onPause() {
        super.onPause();
    }
}
