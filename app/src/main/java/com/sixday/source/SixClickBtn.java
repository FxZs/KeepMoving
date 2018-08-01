package com.sixday.source;

import android.util.Log;

import com.sixday.moudle.ClickEntity;

import org.json.JSONObject;

import java.util.List;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/8/1.
 */

public class SixClickBtn implements SixClickNumberSource{
    OkHttpClient client=new OkHttpClient();
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    @Override
    public void insertSixClickNumberSource(final ClickEntity clickEntity) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //把请求的内容字符串转换为json
                try {
                 JSONObject json=new JSONObject();
                    json.put("clicktext",clickEntity.getClickBtnText());
                    json.put("clicktime",clickEntity.getClickBtnTime());
                    json.put("describe",clickEntity.getBtnNextDecriber());
                    RequestBody body = RequestBody.create(JSON,json.toString() );
                    //RequestBody formBody = new FormEncodingBuilder()
                    Request request = new Request.Builder()
                            .url("http://localhost:8080/a/click")
                            .post(body)
                            .build();
                    Response response = client.newCall(request).execute();
                    String result = response.body().string();
                    Log.i("SixClickBtn",result);
                }catch (Exception e){

                }
            }
        }){

        }.start();



    }

    @Override
    public List<ClickEntity> querySixClickNumberSource() {
        return null;
    }
}
