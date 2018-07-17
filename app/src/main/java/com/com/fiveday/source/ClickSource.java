package com.com.fiveday.source;

import com.com.fiveday.OnclickEntity;

import java.util.List;

/**
 * Created by Administrator on 2018/7/14.
 */

public interface ClickSource {
 void amountInsertClickTimes(OnclickEntity onclickEntity);
 List<OnclickEntity> readClickTimes();
}
