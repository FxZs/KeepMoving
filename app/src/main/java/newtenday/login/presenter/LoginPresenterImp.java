package newtenday.login.presenter;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.Subject;
import newtenday.login.retrofitjiekou.LoginRetrofit;
import newtenday.login.view.LoginView;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zhangpingzhen on 2018/10/10.
 */

public class LoginPresenterImp implements LoginPresenter {
    private LoginView loginView;
    String url="http://192.168.1.109:8080/";

    public LoginPresenterImp(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void start() {

    }

    @Override
    public void userLogin(String name, String pwd) {
       /* Map<String,String> map=new HashMap<>();
        map.put("loginname",name);
        map.put("pwd",pwd);*/
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        LoginRetrofit loginRetrofit=retrofit.create(LoginRetrofit.class);

                 loginRetrofit.getLogin(name,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        String res=o.toString();
                       if(res.equals("true")){
                            loginView.showLoginSuccessfulMeg("登录成功");

                        }else{
                            loginView.showLoginFailMsg("登录失败");
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        loginView.showLoginFailMsg("失败啦");
                    }
                });

    }
}
