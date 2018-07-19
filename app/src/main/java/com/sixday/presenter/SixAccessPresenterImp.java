package com.sixday.presenter;

import com.cn.room.activity.App;
import com.sixday.moudle.AccessEntity;
import com.sixday.source.SixAccessLocalSource;
import com.sixday.view.SixAccessView;

/**
 * Created by zhangpingzhen on 2018/7/19.
 */

public class SixAccessPresenterImp implements SixAccessPresenter{
    private SixAccessView sixAccessView;
    private SixAccessLocalSource sixAccessLocalSource;

    public SixAccessPresenterImp(SixAccessView sixAccessView) {
        this.sixAccessView = sixAccessView;
        this.sixAccessLocalSource=new SixAccessLocalSource(App.getSixAccessBase().sixAccessDao());
        sixAccessView.setPresenter(this);
    }

    @Override
    public void insertAccessPresenter(AccessEntity accessEntity) {
      sixAccessLocalSource.insertAccessSource(accessEntity);
    }

    @Override
    public void queryAccessPresenter() {
        sixAccessView.showSixAccessView(sixAccessLocalSource.queryAccessSource());
    }

    @Override
    public void start() {

    }
}
