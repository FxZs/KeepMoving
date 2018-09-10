package com.sixday.source;

import android.util.Log;

import com.cn.room.activity.App;
import com.sixday.dao.RetorDao;
import com.sixday.moudle.News;

import org.json.JSONObject;

import java.io.IOException;
import java.util.Locale;
import java.util.Map;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/8/13.
 * 拦截http
 */

public class MyIntercepter implements Interceptor{
    private  final  static String TEST="MyIntercepter.class";
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    RetorDao retorDao;
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        retorDao= App.getRetorDatabase().retorDao();
        News news=new News();
        news.setRequestMethord(request.method());
        news.setRequestTime(System.currentTimeMillis()+"");
        news.setRequestBody(request.body().toString());
        news.setRequestUrl(request.url().toString());
        news.setIshttp(request.isHttps());
        retorDao.insertRetorNew(news);
        String url=request.url().toString();
        String method=request.method().toString();
        boolean ishttp=request.isHttps();
        String body=request.body().toString();

        Log.i("TEST", "MyIntercepter" + request.url());
        Log.i("TEST", "MyIntercepter" + request.method());
        Log.i("TEST", "MyIntercepter" + request.isHttps());
        Log.i("TEST", "MyIntercepter" + request.body());

        insetFuwuqi(url,method,ishttp,body);//往服务器数据库插入数据
        Log.i("TEST", String.format(Locale.getDefault(),
                "MyIntercepter.intercept.requestbody -> {contentType : %1$s, contentLength : %2$d, toString : %3$s}",
                request.body().contentType().toString(),
                request.body().contentLength(),
                request.body().toString()));
        Response response = chain.proceed(request);

        Log.i(TEST, "MyIntercepter.intercept.response.message -> " + response.message());
        Log.i(TEST, "MyIntercepter.intercept.response.toString -> " + response.toString());

        // 在这里不能通过这个来获取服务器返回的内容，否则会报错
        // response.body().string();
        return response;
    }

    private void insetFuwuqi(final String url, final String method, final boolean ishttp,final String mybody) {

          new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                         /*第一种方法*/
                          RequestBody body = new FormBody.Builder()
                                    .add("url", url)
                                    .add("method", method)
                                  .add("myishttp",ishttp+"")
                                  .add("body",mybody)
                                    .build();
                         /*第二种方法*/
                           // RequestBody body = RequestBody.create(JSON,
                                 //   new JSONObject().put("url",url).put("method",method).put("ishttp",ishttp).put("mybody",mybody).toString());

                            Request request = new Request.Builder()
                                    .url("http://192.168.1.109:8080/retor/insertreto")
                                    .post(body)
                                    .build();
                            OkHttpClient client=new OkHttpClient.Builder().build();
                            Response response = client.newCall(request).execute();
                            Log.i("SixAccessNetSource",response.body().string());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }
        ).start();

    }

    }



