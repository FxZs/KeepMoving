package com.com.fiveday.source;

import com.com.fiveday.HandleEntity;

import java.util.List;

/**
 * Created by zhangpingzhen on 2018/7/17.
 */

public interface HandleSource {
    void insertHandleMsgSource(HandleEntity handleEntity);
    List<HandleEntity> queryHandleMsgSource();

}
