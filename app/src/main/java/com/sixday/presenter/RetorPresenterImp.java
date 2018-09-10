package com.sixday.presenter;

import com.cn.room.activity.App;
import com.sixday.dao.RetorDao;
import com.sixday.moudle.News;
import com.sixday.view.RetoView;

/**
 * Created by Administrator on 2018/8/14.
 */

public class RetorPresenterImp implements RetorPresenter{
    private RetoView retoView;
    RetorDao dao;

    public RetorPresenterImp(RetoView retoView, RetorDao dao) {
        this.retoView = retoView;
        this.dao = dao;
    }

    @Override
    public void queryRetor() {
           dao.queryRetorNew();
    }
}
