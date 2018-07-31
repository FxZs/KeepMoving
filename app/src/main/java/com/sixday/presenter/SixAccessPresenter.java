package com.sixday.presenter;

import com.fx.base.BasePresenter;
import com.sixday.moudle.AccessEntity;

/**
 * Created by zhangpingzhen on 2018/7/19.
 * Presenter类是具体的逻辑业务处理类，该类为纯Java类，
 * 不包含任何Android API，负责请求数据，并对数据请求的反馈进行处理。
 * Presenter类的构造方法中有一个View接口的参数，
 * 是为了能够通过View接口通知Activity进行更新界面等操作。
 */

public interface SixAccessPresenter extends BasePresenter{
void insertAccessPresenter(AccessEntity accessEntity);
void queryAccessPresenter();

}
