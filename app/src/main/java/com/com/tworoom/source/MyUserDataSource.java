package com.com.tworoom.source;

import com.com.tworoom.MyUser;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;

/**
 * Created by zhangpingzhen on 2018/7/11.
 */

public interface MyUserDataSource {
    void SaveUser(MyUser myUser);
    Flowable<List<MyUser>> HuoquData();
}
