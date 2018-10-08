package com.com.tworoom.source;

import com.com.tworoom.MyUser;
import com.com.tworoom.twodao.TwoUserDao;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
/**
 * Created by zhangpingzhen on 2018/7/11.
 */

public class MyUserLocaldatasource implements MyUserDataSource{
    private TwoUserDao userDao;

    public MyUserLocaldatasource(TwoUserDao userDao) {

        this.userDao = userDao;
    }

    @Override
    public void SaveUser(MyUser myUser) {
        userDao.insertstartdata(myUser);

    }

    @Override
    public Flowable<List<MyUser>> HuoquData() {
        return userDao.getData();
    }
}
