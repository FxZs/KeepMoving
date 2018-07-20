package com.sevenday.view;

import com.fx.base.BaseView;
import com.sevenday.presenter.SenvenLoginPresenter;

/**
 * Created by zhangpingzhen on 2018/7/20.
 */

public interface SenvenLoginView extends BaseView<SenvenLoginPresenter>{
    void showLoginResult(String msg);

}
