package com.com.fourday.source;

import com.com.fourday.AccessTime;
import com.com.fourday.dao.AccessTimeDao;

import java.util.HashMap;
import java.util.List;

/**
 * Created by zhangpingzhen on 2018/7/12.
 */

public class AccessTimeCachSource implements AccessTimeSource{
   private AccessTimeDao accessTimeDao;

    private HashMap<String,AccessTime> map  = new HashMap<>();
    public AccessTimeCachSource(AccessTimeDao accessTimeDao) {
        this.accessTimeDao = accessTimeDao;
    }

    @Override
    public void accountTime(AccessTime accessTime) {
       accessTimeDao.insertTime(accessTime);
        map.put("dasdas",accessTime);
    }

    @Override
    public List<AccessTime> readDataTime() {
        return accessTimeDao.queryTime();
    }

}
