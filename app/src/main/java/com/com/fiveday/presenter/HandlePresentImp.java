package com.com.fiveday.presenter;

import com.cn.room.activity.App;
import com.com.fiveday.HandleEntity;
import com.com.fiveday.source.HandleLocalSource;
import com.com.fiveday.view.HandleView;

/**
 * Created by zhangpingzhen on 2018/7/17.
 */

public class HandlePresentImp implements HandlePresenter{
    private HandleView handleView;
    private HandleLocalSource handleLocalSource;

    public HandlePresentImp(HandleView handleView) {
        this.handleView = handleView;
        this.handleLocalSource=new HandleLocalSource(App.getHandleBaseView().handleDao());
    }

    @Override
    public void insertHandlePresenter(HandleEntity handleEntity) {
            handleLocalSource.insertHandleMsgSource(handleEntity);
    }

    @Override
    public void queryHandlePresenter() {
        handleLocalSource.queryHandleMsgSource();
    }

    @Override
    public void catchhandleder() {

    }

    @Override
    public void start() {

    }
}
