package com.sixday.source;

import android.arch.persistence.room.Dao;
import android.util.Log;

import com.sixday.moudle.Api;
import com.sixday.moudle.ClickEntity;

import org.json.JSONObject;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

/**
 * Created by Administrator on 2018/8/6.
 */

public class SixClickNetSource implements SixClickNumberSource{

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
  /* HttpLoggingInterceptor  loggingInterceptor=new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
       @Override
       public void log(String message) {
           Log.i("TEST", "SixClickNetSource.HttpLoggingInterceptor.log().message -> " + message);
       }
   });*/



    @Override
    public void insertSixClickNumberSource(final ClickEntity clickEntity) {
        String url="http://192.168.1.109:8080/click/insert";
        OkHttponeday okHttponeday=new OkHttponeday();

        Map<String,String> map=new HashMap<>();
        map.put("btntime",clickEntity.getClickBtnTime());
        map.put("btntext",clickEntity.getClickBtnText());
        map.put("btndescribe",clickEntity.getBtnNextDecriber());
        map.put("whichpage",clickEntity.getWhichPage());
        okHttponeday.insert(map,url);
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                            *//*第一种方法*//*
                          *//*  RequestBody formBody = new FormBody.Builder()
                                    .add("startdata", accessEntity.getStartdata())
                                    .add("pausedata", accessEntity.getPausedata())
                                    .build();*//*
                          *//*第二种方法*//*
                    RequestBody body = RequestBody.create(JSON,
                            new JSONObject().put("btntime",clickEntity.getClickBtnTime()).put("btntext",clickEntity.getClickBtnText())
                                    .put("btndescribe",clickEntity.getBtnNextDecriber()).put("whichpage",clickEntity.getWhichPage()).toString()
                    );
                *//*    Request request = new Request.Builder()
                            .url("http://192.168.1.109:8080/click/insert")
                            .post(body)
                            .build();*//*
                  *//*  loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                    OkHttpClient client = new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();*//*
                   *//* OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new MyIntercepter()).build();
                    Response response = client.newCall(request).execute();*//*


                    OkHttponeday okHttponeday=new OkHttponeday();
                    okHttponeday.insert(request);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();*/
    }

    @Override
    public List<ClickEntity> querySixClickNumberSource() {
        return null;
    }
}
