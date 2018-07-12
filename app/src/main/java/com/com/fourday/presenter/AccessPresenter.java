package com.com.fourday.presenter;

import com.com.fourday.AccessTime;
import com.fx.base.BasePresenter;

/**
 * Created by zhangpingzhen on 2018/7/12.
 */

public interface AccessPresenter extends BasePresenter{
    void manageAccessData(AccessTime accessTime);//插入就叫 insert ， P 和dao 要尽量保持一致哦
    void fetchAccessData();
}
