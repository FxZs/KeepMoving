package com.sixday.view;

import com.fx.base.BaseView;
import com.sixday.moudle.AccessEntity;
import com.sixday.presenter.SixAccessPresenter;

import java.util.List;

/**
 * Created by zhangpingzhen on 2018/7/19.
 * View接口是Activity与Presenter层的中间层，它的作用是根据具体业务的需要，
 * 为Presenter提供调用Activity中具体UI逻辑操作的方法。
 */

public interface SixAccessView extends BaseView<SixAccessPresenter>{
    void showSixAccessView(List<AccessEntity> accessEntities) ;
}
