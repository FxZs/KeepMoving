package com.sixday.source;

import com.sixday.dao.SixClickNumberDao;
import com.sixday.moudle.ClickEntity;

import java.util.List;

/**
 * Created by zhangpingzhen on 2018/7/19.
 */

public class SixClickNumberLocalSource implements SixClickNumberSource{
    private SixClickNumberDao sixClickNumberDao;

    public SixClickNumberLocalSource(SixClickNumberDao sixClickNumberDao) {
        this.sixClickNumberDao = sixClickNumberDao;
    }

    @Override
    public void insertSixClickNumberSource(ClickEntity clickEntity) {
        sixClickNumberDao.insertSixClickNumber(clickEntity);
    }

    @Override
    public List<ClickEntity> querySixClickNumberSource() {
        return sixClickNumberDao.querySixClickNumber();
    }
}
