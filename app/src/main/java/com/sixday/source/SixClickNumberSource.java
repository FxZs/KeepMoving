package com.sixday.source;

import com.sixday.moudle.ClickEntity;

import java.util.List;

/**
 * Created by zhangpingzhen on 2018/7/19.
 */

public interface SixClickNumberSource {
    void insertSixClickNumberSource(ClickEntity clickEntity);
    List<ClickEntity> querySixClickNumberSource();
}
