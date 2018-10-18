package newtenday.http;

import android.util.Log;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import newtenday.retrofitjiekou.NewTenRetrofit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zhangpingzhen on 2018/10/17.
 */

public class NewTenHttp {
    private static String url="http://192.168.8.222:8088/";
    /*拦截器   可拦截访问服务器的内容*/
    OkHttpClient client=new OkHttpClient.Builder()
            .addInterceptor(new MyIntercepter()).build();

    Retrofit retrofit=new Retrofit.Builder()
            .baseUrl(url)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();
    NewTenRetrofit tenRetrofit=retrofit.create(NewTenRetrofit.class);

    public void insert(Map<String,String> map){
        tenRetrofit.insertNewTen(map)
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                      System.out.print("aaaa"+o.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                       // Log.i("ssssss",throwable.getMessage());
                    }
                });
    }


    public  void  insertClick(Map<String,String> map){
        tenRetrofit.insertClick(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        Log.v("click",o.toString());
                    }
                });
    }
    public void insertHandle(Map<String,String> map){
        tenRetrofit.insertHandle(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        Log.v("handle",o.toString());
                    }
                });
    }
}
