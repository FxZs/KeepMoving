package newtwoday.com.presenter;

import com.fx.base.BasePresenter;

import newtwoday.com.moudle.OnclickTimesNum;

/**
 * Created by Administrator on 2018/9/10.
 */

public interface OnClickPresenter extends BasePresenter{
    void insertOnClickPresenter(OnclickTimesNum onclickTimesNum);
    void queryOnClickPresenter();
}
