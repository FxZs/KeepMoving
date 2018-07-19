package com.sixday.source;

import com.sixday.moudle.AccessEntity;

import java.util.List;

/**
 * Created by zhangpingzhen on 2018/7/19.
 */

public interface SixAccessSource {
    void insertAccessSource(AccessEntity accessEntity);
    List<AccessEntity> queryAccessSource();
}
