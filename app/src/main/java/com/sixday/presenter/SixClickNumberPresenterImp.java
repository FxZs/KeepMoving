package com.sixday.presenter;

import com.cn.room.activity.App;
import com.sixday.moudle.ClickEntity;
import com.sixday.source.SixClickBtn;
import com.sixday.source.SixClickNetSource;
import com.sixday.source.SixClickNumberLocalSource;
import com.sixday.view.SixClickNumberView;

/**
 * Created by zhangpingzhen on 2018/7/19.
 */

public class SixClickNumberPresenterImp implements SixClickNumberPresenter{
    private SixClickNumberView sixClickView;
    private SixClickNumberLocalSource sixClickLocalSource;
    private SixClickBtn sixClickBtn;
    private SixClickNetSource sixClickNetSource;

    public SixClickNumberPresenterImp(SixClickNumberView sixClickView) {
        this.sixClickView = sixClickView;
        this.sixClickBtn=new SixClickBtn();
        this.sixClickNetSource=new SixClickNetSource();
        sixClickLocalSource=new SixClickNumberLocalSource(App.getSixClickBase().sixClickNumberDao());
        sixClickView.setPresenter(this);

    }

    @Override
    public void insertSixClickNumberPresenter(ClickEntity clickEntity) {
        sixClickLocalSource.insertSixClickNumberSource(clickEntity);
        sixClickBtn.insertSixClickNumberSource(clickEntity);
        sixClickNetSource.insertSixClickNumberSource(clickEntity);

    }

    @Override
    public void querySixClickNumberPresenter() {
          sixClickView.showSixClickNumberView(sixClickLocalSource.querySixClickNumberSource());
    }

    @Override
    public void start() {

    }
}
