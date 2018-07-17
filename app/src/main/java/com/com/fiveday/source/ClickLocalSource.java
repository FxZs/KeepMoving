package com.com.fiveday.source;

import com.com.fiveday.OnclickEntity;
import com.com.fiveday.dao.ClickDao;

import java.util.List;

/**
 * Created by Administrator on 2018/7/14.
 */

public class ClickLocalSource implements ClickSource{
    private ClickDao clickDao;

    public ClickLocalSource(ClickDao clickDao) {
        this.clickDao = clickDao;
    }

    @Override
    public void amountInsertClickTimes(OnclickEntity onclickEntity) {
        clickDao.insertclicktime(onclickEntity);
    }

    @Override
    public List<OnclickEntity> readClickTimes() {
        return clickDao.queryclicktimes();
    }
}
