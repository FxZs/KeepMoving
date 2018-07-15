package com.com.fiveday.view;

import com.com.fiveday.OnclickEntity;
import com.fx.base.BaseView;

import java.util.List;

/**
 * Created by Administrator on 2018/7/14.
 */

public interface ClickView extends BaseView{
    void showClickTimes(List<OnclickEntity> onclickEntities);
}
