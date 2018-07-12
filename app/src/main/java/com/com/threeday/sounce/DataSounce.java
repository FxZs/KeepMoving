package com.com.threeday.sounce;

import com.com.threeday.Data;

import java.util.List;

/**
 * Created by zhangpingzhen on 2018/7/12.
 */

public interface DataSounce {
    void AcountData(Data data);//处理插入数据库里的数据
    List<Data> ReadData();//处理从数据库里查询到的数据
}
