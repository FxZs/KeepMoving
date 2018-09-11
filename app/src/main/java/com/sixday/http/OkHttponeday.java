package com.sixday.http;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by zhangpingzhen on 2018/9/11.
 */

public class OkHttponeday {
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    public void insert(Map<String, Object> map, String url) {


        JSONObject jsonobject=new JSONObject();
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
            }



    }

}
