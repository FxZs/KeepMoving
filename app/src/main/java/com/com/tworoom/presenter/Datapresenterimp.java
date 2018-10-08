package com.com.tworoom.presenter;

import com.cn.room.activity.App;
import com.com.tworoom.MyUser;
import com.com.tworoom.source.MyUserLocaldatasource;
import com.com.tworoom.view.DataView;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by zhangpingzhen on 2018/7/11.
 */

public class Datapresenterimp implements datapresenter{
    private MyUserLocaldatasource datasource;
    private DataView dataView;

    public Datapresenterimp(DataView view) {
        this.datasource = new MyUserLocaldatasource(App.getTworoomdatabase().twoUserDao());
        this.dataView=view;

    }

    @Override
    public void totaltime(MyUser usertime) {

        datasource.SaveUser(usertime);
//        App.getTworoomdatabase().twoUserDao().insertstartdata(usertime);
    }

    @Override
    public void dudatashuju() {
        datasource.HuoquData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(myUsers -> dataView.showData(myUsers));


    }

    @Override
    public void start() {

    }
}
