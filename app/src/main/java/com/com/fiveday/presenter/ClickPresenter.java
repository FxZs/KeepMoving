package com.com.fiveday.presenter;

import com.com.fiveday.OnclickEntity;
import com.fx.base.BasePresenter;

/**
 * Created by Administrator on 2018/7/14.
 */

public interface ClickPresenter extends BasePresenter{
    void insertClickTime(OnclickEntity onclickEntity);
    void queryClickTimes();
}
