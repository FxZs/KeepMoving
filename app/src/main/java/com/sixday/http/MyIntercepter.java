package com.sixday.http;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by zhangpingzhen on 2018/9/11.
 */

public class MyIntercepter implements Interceptor{
    private static final String TAG="MyIntercepter.class";
    private String url="http://192.168.8.222:8088/inter/insertIntor";
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        long t1 = System.nanoTime();
        Log.i(TAG,request.url().toString());
        Log.i(TAG,request.method().toString());
        Log.i(TAG,request.isHttps()+"");
        Log.i(TAG,request.body().toString());
     String myurl=request.url().toString();
     String mymethod=request.method().toString();
     String ishttp=request.isHttps()+"";
     String mybody=request.body().toString();
      
      
     insertInter(myurl,mymethod,ishttp,mybody);

        Response response = chain.proceed(request);


        return response;
    }

    private void insertInter(String myurl, String mymethod, String ishttp, String mybody) {
        try {
            RequestBody body = RequestBody.create(JSON,
                    new JSONObject().put("myurl",myurl).put("mymethod",mymethod)
                            .put("ishttp",ishttp).put("mybody",mybody).toString());
            Request request = new Request.Builder()
                    .url("http://192.168.8.222:8088/inter/insertIntor")
                    .post(body)
                    .build();
            OkHttpClient client = new OkHttpClient.Builder().build();
            Response response = client.newCall(request).execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
