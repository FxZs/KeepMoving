package com.fx.presenter;

import com.fx.keepmoving.LoginContract;
import com.fx.modle.User;
import com.fx.view.LoginView;

/**
 * Created by zhangpingzhen on 2018/7/3.
 */

public class LoginPresenterImp implements LoginContract.LoginPresenter {
    //这个就是刚才要不要Contract的区别，嗯引入的路径不一样而已  ，不写出来怕你不明白
    //这里引用要保持一致
    private LoginContract.LoginView view;

    public void setView(LoginContract.LoginView view) {
        this.view = view;
    }

    public LoginPresenterImp(LoginContract.LoginView view) {

        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void login(User user) {
        //这里就会被调用
        //然后具体登录请求，检查返回结果那些

//        检查结果 是true （后台返回成功）就是成功
        if (true) {
            view.showLoginResult("成功");
        }
        else if(false){
            view.showLoginResult("失败");
        }
        //      类似这种，看具体后台返回情况，有的是恩状态码 switch case 也行 反正就是判断区分，分别展示
//        view.showLoginResult("成功，失败，网络异常什么的");//三个错误都写一起  怎么给toast出来成功还是失败
    }

    @Override
    public void start() {

    }
}
