package com.com.tworoom.presenter;

import com.cn.room.activity.App;
import com.com.tworoom.MyUser;
import com.com.tworoom.source.MyUserLocaldatasource;
import com.com.tworoom.view.DataView;

/**
 * Created by zhangpingzhen on 2018/7/11.
 */

public class Datapresenterimp implements datapresenter{
    private MyUserLocaldatasource datasource;
    private DataView dataView;

    public Datapresenterimp( ) {
        this.datasource = new MyUserLocaldatasource(App.getTworoomdatabase().twoUserDao());
    }

    @Override
    public void totaltime(MyUser usertime) {
           datasource.SaveUser(usertime);
    }

    @Override
    public void start() {

    }
}
