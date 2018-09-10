package com.sixday.source;

import com.sixday.moudle.ClickEntity;

import java.util.List;

/**
 * Created by Administrator on 2018/8/13.
 */

public class SixClickNetRetSource implements SixClickNumberSource{

    @Override
    public void insertSixClickNumberSource(ClickEntity clickEntity) {
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();

    }

    @Override
    public List<ClickEntity> querySixClickNumberSource() {
        return null;
    }
}
