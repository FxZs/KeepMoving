package com.sixday.source;

import android.util.Log;

import com.sixday.moudle.AccessEntity;
import com.sixday.moudle.ClickEntity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/9/3.
 */

public class OkHttponeday {
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    public void insert(Map<String,String> map, String url){


        JSONObject aa= new JSONObject();
           try {
               for (Map.Entry<String,String> entry:map.entrySet()) {
                   aa.put(entry.getKey(), entry.getValue());
               }
               RequestBody body=RequestBody.create(JSON,aa.toString());
           /*第一种方法*/
                          /* RequestBody formBody = new FormBody.Builder()
                                    .add("btntime", a)
                                    .add("btntext", b)
                                    .add("btndescribe", c)
                                    .add("whichpage", d)
                                    .build();*/
                          /*第二种方法*/
     /* RequestBody body = RequestBody.create(JSON,
                new JSONObject().put("btntime",clickEntity.getClickBtnTime()).put("btntext",clickEntity.getClickBtnText())
                        .put("btndescribe",clickEntity.getBtnNextDecriber()).put("whichpage",clickEntity.getWhichPage()).toString()
        );*/
               Request request = new Request.Builder()
                       .url(url)
                       .post(body)
                       .build();
               OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new MyIntercepter()).build();
                client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }
                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    System.out.println( "getEnqueue = "+response.body().string()+ Thread.currentThread().getName());
                }
            });
              // Response response = client.newCall(request).execute();
           } catch (Exception e) {
               e.printStackTrace();
           }



//            Log.i("OkHttponeday",response.body().string());

    }
}
