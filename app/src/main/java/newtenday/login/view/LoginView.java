package newtenday.login.view;

import com.fx.base.BaseView;

import newtenday.login.presenter.LoginPresenter;

/**
 * Created by zhangpingzhen on 2018/10/10.
 */

public interface LoginView extends BaseView<LoginPresenter>{
    void showLoginSuccessfulMeg(String msg);
    void showLoginFailMsg(String msg);
}
