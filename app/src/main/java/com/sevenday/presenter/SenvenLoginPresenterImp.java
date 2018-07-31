package com.sevenday.presenter;

import com.sevenday.modle.LoginEntity;
import com.sevenday.view.SenvenLoginView;

/**
 * Created by zhangpingzhen on 2018/7/20.
 */

public class SenvenLoginPresenterImp implements SenvenLoginPresenter{
    private SenvenLoginView senvenLoginView;

    public SenvenLoginPresenterImp(SenvenLoginView senvenLoginView) {
        this.senvenLoginView = senvenLoginView;
        senvenLoginView.setPresenter(this);
    }

    @Override
    public void Login(LoginEntity loginEntity) {
        if (true){
            senvenLoginView.showLoginResult("登录成功");
        }

    }
}
