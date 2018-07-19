package com.sixday.source;

import com.sixday.moudle.HandleEntity;

import java.util.List;

/**
 * Created by zhangpingzhen on 2018/7/19.
 */

public interface SixHandleSource {
    void insertSixHandleSource(HandleEntity handleEntity);
    List<HandleEntity>  querySixHandleSource();
}
