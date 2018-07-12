package com.com.threeday.view;

import com.com.threeday.Data;
import com.com.threeday.presenter.DataPresenter;
import com.com.threeday.presenter.Datapresenterimp;
import com.fx.base.BaseView;

import java.util.List;

/**
 * Created by zhangpingzhen on 2018/7/12.
 */

public interface DataView extends BaseView<DataPresenter>{
    void showData(List<Data> data);
}
