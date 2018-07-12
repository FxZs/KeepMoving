package com.com.fourday.source;

import com.com.fourday.AccessTime;
import com.com.fourday.dao.AccessTimeDao;

import java.util.List;

/**
 * Created by zhangpingzhen on 2018/7/12.
 */

public class AccessTimeLocalSource implements AccessTimeSource{
    private AccessTimeDao accessTimeDao;

    public AccessTimeLocalSource(AccessTimeDao accessTimeDao) {
        this.accessTimeDao = accessTimeDao;
    }

    @Override
    public void accountTime(AccessTime accessTime) {
accessTimeDao.insertTime(accessTime);
    }

    @Override
    public List<AccessTime> readDataTime() {
        return accessTimeDao.queryTime();
    }


}
