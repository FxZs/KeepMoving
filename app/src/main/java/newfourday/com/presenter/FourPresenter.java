package newfourday.com.presenter;

import com.fx.base.BasePresenter;

import entity.AccessTimeEntity;

/**
 * Created by zhangpingzhen on 2018/9/14.
 */

public interface FourPresenter extends BasePresenter {
    void insertFour(AccessTimeEntity accessTimeEntity);
    void  queryFour();
}
