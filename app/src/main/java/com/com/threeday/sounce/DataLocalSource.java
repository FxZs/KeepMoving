package com.com.threeday.sounce;

import com.com.threeday.Data;
import com.com.threeday.dao.DataDao;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by zhangpingzhen on 2018/7/12.
 */

public class DataLocalSource implements DataSounce{
private DataDao dataDao;

    public DataLocalSource(DataDao dataDao) {
        this.dataDao = dataDao;
    }

    @Override
    public void AcountData(Data data) {
        dataDao.insertData(data);
    }

    @Override
    public Flowable<List<Data>> ReadData() {

        return dataDao.QueryData();
    }
}
