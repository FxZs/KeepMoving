package com.com.fiveday.view;

import com.com.fiveday.HandleEntity;
import com.fx.base.BaseView;

import java.util.List;

/**
 * Created by zhangpingzhen on 2018/7/17.
 */

public interface HandleView extends BaseView{
    void ShowWhatHandle(List<HandleEntity> handleEntities);
}
