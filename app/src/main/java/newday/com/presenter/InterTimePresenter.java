package newday.com.presenter;

import com.fx.base.BasePresenter;

import newday.com.moudle.InterTimeEntity;

/**
 * Created by Administrator on 2018/9/10.
 */

public interface InterTimePresenter extends BasePresenter{
    void insertInterTimePresenter(InterTimeEntity interTimeEntity);
    void queryInterTimePresenter();
}
