package com.sixday.view;

import com.fx.base.BaseView;
import com.sixday.moudle.ClickEntity;
import com.sixday.presenter.SixClickNumberPresenter;

import java.util.List;

/**
 * Created by zhangpingzhen on 2018/7/19.
 */

public interface SixClickNumberView extends BaseView<SixClickNumberPresenter>{
    void  showSixClickNumberView(List<ClickEntity> clickEntities);
}
