package newtenday.login.presenter;

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
    String url="http://192.168.8.222:8088/";

    public LoginPresenterImp(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void start() {

    }

    @Override
    public void userLogin(String name, String pwd) {
        Map<String,String> map=new HashMap<>();
        map.put("loginname",name);
        map.put("pwd",pwd);
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(url)
                 .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        LoginRetrofit loginRetrofit=retrofit.create(LoginRetrofit.class);

                 loginRetrofit.getLogin(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object data) throws Exception {
                             data.toString();
                             if(data.equals("true")){
                                 loginView.showLoginSuccessfulMeg(data.toString());
                             }else{
                                 loginView.showLoginFailMsg(data.toString());
                             }
                    }
                });

    }
}
