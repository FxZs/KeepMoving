package com.com.fourday.source;

import com.com.fourday.AccessTime;

import java.util.List;

/**
 * Created by zhangpingzhen on 2018/7/12.
 */

public interface AccessTimeSource {
    void accountTime(AccessTime accessTime);
    List<AccessTime> readDataTime();

}
