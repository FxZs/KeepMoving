package com.sixday.presenter;

import com.cn.room.activity.App;
import com.sixday.moudle.HandleEntity;
import com.sixday.source.SixClickNetSource;
import com.sixday.source.SixHandleLocalSource;
import com.sixday.view.SixHandleView;

/**
 * Created by zhangpingzhen on 2018/7/19.
 */

public class SixHandlePresenterImp implements SixHandlePresenter{
    private SixHandleView sixHandleView;
    private SixHandleLocalSource sixHandleLocalSource;


    public SixHandlePresenterImp(SixHandleView sixHandleView) {
        this.sixHandleView = sixHandleView;
        sixHandleLocalSource=new SixHandleLocalSource(App.getSixHandleBase().sixHandleDao());
        sixHandleView.setPresenter(this);
    }

    @Override
    public void insertSixHandlePresenter(HandleEntity handleEntity) {
        sixHandleLocalSource.insertSixHandleSource(handleEntity);
    }

    @Override
    public void querySixHandlePresenter() {
        sixHandleView.showSixHandleView(sixHandleLocalSource.querySixHandleSource());
    }

    @Override
    public void start() {
        querySixHandlePresenter();
    }
}
