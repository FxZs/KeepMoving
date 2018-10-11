package newtenday.login.retrofitjiekou;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by zhangpingzhen on 2018/10/10.
 */

public interface LoginRetrofit {
    /*  当POST请求时，@FormUrlEncoded和@Field简单的表单键值对。两个需要结合使用，否则会报错
    @Query请求参数。无论是GET或POST的参数都可以用它来实现 */
    @FormUrlEncoded
    @POST("userlogin/query")
    Observable<Object> getLogin(@Field("loginname") String name,@Field("pwd") String pwd);

    /*第二种写法  用map*/
    /*@POST("userlogin/query")
    Observable<Object> getLogin(@QueryMap Map<String,String> dedata);*/


    /*@POST("userlogin/query")
    Observable<Object> getLogin(@Query("loginname") String name, @Query("pwd") String pwd);*/
}
