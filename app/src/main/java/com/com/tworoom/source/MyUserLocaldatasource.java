package com.com.tworoom.source;

import com.com.tworoom.MyUser;
import com.com.tworoom.twodao.TwoUserDao;

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
}
