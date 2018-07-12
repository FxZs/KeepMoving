package com.com.fourday.view;

import com.com.fourday.AccessTime;
import com.fx.base.BaseView;

import java.util.List;

/**
 * Created by zhangpingzhen on 2018/7/12.
 */

public interface AccessView extends BaseView{
    void showAccessTime(List<AccessTime> accessTimes);
}
