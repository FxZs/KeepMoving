package com.sixday;

import com.sixday.moudle.ClickEntity;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by zhangpingzhen on 2018/10/9.
 */

public interface RetrofitJiekou {
    @POST("access/insert")
    Observable<Object> getMsg(@QueryMap Map<String,Object> dedata);
}
