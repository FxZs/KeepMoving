package com.fx.keepmoving;

import com.fx.base.BasePresenter;
import com.fx.base.BaseView;
import com.fx.modle.User;

/**
 * Created by zhangpingzhen on 2018/7/3.
 * 这个接口可有可无，是为了将view 和  present 放在一起，方便代码维护
 *
 * 在这里LoginView和LoginPresenter是一一对应的，能理解？嗯
 * LoginPresenter只能能操作LoginView，LoginView也只能操作LoginPresenter，能理解？一般
 * LoginView 用来触发LoginPresenter的登录方法和展示LoginPresenter的处理结果，
 * LoginView 需要做的事情只有LoginPresenter能完成 这个理解？嗯
 * 比如你现在还有别的Presenter，比如付款之类的，你同样有个PayPresenter 继续
 * void setPresenter(T presenter); PayPresenter 传进去取做LoginPresenter的事情能不能完成？晕了？
 * 意思是另一个presenter去做这个present不能做的事情
 * LoginView  extends BaseView<LoginPresenter> 这里就是限定LoginView 只能传LoginPresenter 嗯
 * 这个晚上解释了，我继续了
 * LoginView  extends BaseView<LoginPresenter> 这里就是限定LoginView 只能传LoginPresenter  记住这个就行了饿
 */

public interface LoginContract {


    interface LoginView  extends BaseView<LoginPresenter>{
        void showLoginResult(String result);
    }

    interface LoginPresenter extends BasePresenter {
        void login(User user);
    }

}
