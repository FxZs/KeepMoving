package com.sixday.http;

import android.util.Log;

import com.sixday.RetrofitJiekou;
import com.sixday.moudle.ClickEntity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.Subject;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zhangpingzhen on 2018/9/11.
 */

public class OkHttponeday {
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    public void insert(Map<String, Object> map, String url) {

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://192.168.8.222:8088/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        RetrofitJiekou retrofitJiekou=retrofit.create(RetrofitJiekou.class);
        retrofitJiekou.getMsg(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Object s) {
                        Log.i("aaaaaaaaaaaaaa",s.toString());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });





       /* JSONObject jsonobject=new JSONObject();
        RequestBody body;

            try {
                for (Map.Entry<String,Object> entry:map.entrySet()) {
                    jsonobject.put(entry.getKey(), entry.getValue());
                }
                body=RequestBody.create(JSON,jsonobject.toString());
                final Request request=new Request.Builder().url(url).post(body).build();
                OkHttpClient client=new OkHttpClient.Builder().addInterceptor(new MyIntercepter()).build();
                Call call=client.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                    System.out.print(request.body().toString());
                    }
                });
               // Response response=client.newCall(request).execute();
            } catch (Exception e) {
                e.printStackTrace();
            }*/



    }

}
