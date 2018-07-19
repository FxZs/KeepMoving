package com.sixday.source;

import com.sixday.dao.SixHandleDao;
import com.sixday.moudle.HandleEntity;

import java.util.List;

/**
 * Created by zhangpingzhen on 2018/7/19.
 */

public class SixHandleLocalSource implements SixHandleSource{
    private SixHandleDao sixHandleDao;

    public SixHandleLocalSource(SixHandleDao sixHandleDao) {
        this.sixHandleDao = sixHandleDao;
    }

    @Override
    public void insertSixHandleSource(HandleEntity handleEntity) {
        sixHandleDao.insertSixHandle(handleEntity);
    }

    @Override
    public List<HandleEntity> querySixHandleSource() {
        return sixHandleDao.querySixHandle();
    }
}
