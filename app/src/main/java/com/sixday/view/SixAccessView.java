package com.sixday.view;

import com.fx.base.BaseView;
import com.sixday.moudle.AccessEntity;
import com.sixday.presenter.SixAccessPresenter;

import java.util.List;

/**
 * Created by zhangpingzhen on 2018/7/19.
 */

public interface SixAccessView extends BaseView<SixAccessPresenter>{
    void showSixAccessView(List<AccessEntity> accessEntities) ;
}
