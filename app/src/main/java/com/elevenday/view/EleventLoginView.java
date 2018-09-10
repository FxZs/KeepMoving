package com.elevenday.view;

import com.elevenday.presenter.EleventLoginPresent;
import com.fx.base.BaseView;

/**
 * Created by Administrator on 2018/8/3.
 */

public interface EleventLoginView extends BaseView<EleventLoginPresent>{
    void showLoginResult(String msg);
}
