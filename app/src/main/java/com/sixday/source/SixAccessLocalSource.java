package com.sixday.source;

import com.sixday.dao.SixAccessDao;
import com.sixday.moudle.AccessEntity;

import java.util.List;

/**
 * Created by zhangpingzhen on 2018/7/19.
 */

public class SixAccessLocalSource implements SixAccessSource{
    private SixAccessDao sixAccessDao;

    public SixAccessLocalSource(SixAccessDao sixAccessDao) {
        this.sixAccessDao = sixAccessDao;
    }

    @Override
    public void insertAccessSource(AccessEntity accessEntity) {
        sixAccessDao.insertSixAccess(accessEntity);
    }

    @Override
    public List<AccessEntity> queryAccessSource() {
        return sixAccessDao.querySixAccess();
    }
}
