package com.sixday.moudle;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2018/8/13.
 */

public interface Api {
    @Headers("apikey:")
    @GET("word/word")
    Call<News> getNiews(@Header("he") String hearder, @Query("num") String num, @Query("page") String page);


}
