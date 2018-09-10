package com.sixday.source;

import android.util.Log;

import com.sixday.dao.SixAccessDao;
import com.sixday.moudle.AccessEntity;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by zhangpingzhen on 2018/7/19.
 */

public class SixAccessNetSource implements SixAccessSource{
private String url="http://192.168.1.109:8080/access/insert";
    @Override
    public void insertAccessSource(final AccessEntity accessEntity) {

        Map<String ,String> map=new HashMap<>();
        map.put("startdata",accessEntity.getStartdata());
        map.put("pausedata",accessEntity.getPausedata());
        OkHttponeday okHttponeday=new OkHttponeday();
        okHttponeday.insert(map,url);

      /* new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                         *//*第一种方法*//*
                           RequestBody formBody = new FormBody.Builder()
                                    .add("startdata", accessEntity.getStartdata())
                                    .add("pausedata", accessEntity.getPausedata())
                                    .build();
                         *//*第二种方法*//*
                            RequestBody body = RequestBody.create(JSON,
                                    new JSONObject().put("startdata",accessEntity.getStartdata()).put("pausedata",accessEntity.getPausedata()).toString()
 );
                            Request request = new Request.Builder()
                                    .url("http://192.168.1.109:8080/access/insert")
                                    .post(body)
                                    .build();
                            Response response = client.newCall(request).execute();
                            Log.i("SixAccessNetSource",response.body().string());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
        ).start();*/

    }

    @Override
    public List<AccessEntity> queryAccessSource() {
        return null;
    }
}
