package com.elevenday.presenter;

import com.elevenday.bean.ElevenLoginEntity;
import com.elevenday.view.EleventLoginView;

/**
 * Created by Administrator on 2018/8/3.
 */

public class EleventLoginPresenterImp implements EleventLoginPresent{
    private EleventLoginView eleventLoginView;


    public EleventLoginPresenterImp(EleventLoginView eleventLoginView) {
        this.eleventLoginView = eleventLoginView;
        eleventLoginView.setPresenter(this);
    }

    public void doLogin(ElevenLoginEntity elevenLoginEntity) {
        String name=elevenLoginEntity.getUsername().toString();
        String pwd=elevenLoginEntity.getUserpwd().toString();
            if(name.equals("admin")&& pwd.equals("123456")){
                eleventLoginView.showLoginResult("登陆成功");
            }else{
                eleventLoginView.showLoginResult("登陆失败");
            }



    }

    @Override
    public void start() {

    }
}
