package newtenday.login.presenter;

import com.fx.base.BasePresenter;

/**
 * Created by zhangpingzhen on 2018/10/10.
 */

public interface LoginPresenter extends BasePresenter{
    void  userLogin(String name,String pwd);
}
