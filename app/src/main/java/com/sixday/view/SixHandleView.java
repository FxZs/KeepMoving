package com.sixday.view;

import com.fx.base.BaseView;
import com.sixday.moudle.HandleEntity;
import com.sixday.presenter.SixHandlePresenter;

import java.util.List;

/**
 * Created by zhangpingzhen on 2018/7/19.
 */

public interface SixHandleView extends BaseView<SixHandlePresenter>{
    void showSixHandleView(List<HandleEntity> handleEntities);
}
