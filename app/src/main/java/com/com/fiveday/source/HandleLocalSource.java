package com.com.fiveday.source;

import com.com.fiveday.HandleEntity;
import com.com.fiveday.dao.HandleDao;

import java.util.List;

/**
 * Created by Administrator on 2018/7/17.
 */

public class HandleLocalSource implements HandleSource{
    private HandleDao handleDao;

    public HandleLocalSource(HandleDao handleDao) {
        this.handleDao = handleDao;
    }

    @Override
    public void insertHandleMsgSource(HandleEntity handleEntity) {
        handleDao.insertHandleMsg(handleEntity);
    }

    @Override
    public List<HandleEntity> queryHandleMsgSource() {
        return handleDao.queryHandleMsg();
    }
}
