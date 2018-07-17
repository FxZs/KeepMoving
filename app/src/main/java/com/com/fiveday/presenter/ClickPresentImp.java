package com.com.fiveday.presenter;

import com.cn.room.activity.App;
import com.com.fiveday.OnclickEntity;
import com.com.fiveday.source.ClickLocalSource;
import com.com.fiveday.source.ClickSource;
import com.com.fiveday.view.ClickView;

/**
 * Created by Administrator on 2018/7/14.
 */

public class ClickPresentImp implements ClickPresenter{
    private ClickView clickView;
    private ClickLocalSource clickLocalSource;

    public ClickPresentImp(ClickView clickView) {
        this.clickView = clickView;
        this.clickLocalSource = new ClickLocalSource(App.getClickBaseView().clickDao());
    }

    @Override
    public void insertClickTime(OnclickEntity onclickEntity) {
          clickLocalSource.amountInsertClickTimes(onclickEntity);
    }

    @Override
    public void queryClickTimes() {
      clickView.showClickTimes(clickLocalSource.readClickTimes());
    }

    @Override
    public void start() {

    }
}
