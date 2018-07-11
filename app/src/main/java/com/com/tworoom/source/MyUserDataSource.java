package com.com.tworoom.source;

import com.com.tworoom.MyUser;

import java.util.List;

/**
 * Created by zhangpingzhen on 2018/7/11.
 */

public interface MyUserDataSource {
    void SaveUser(MyUser myUser);
    List<MyUser> HuoquData();
}
