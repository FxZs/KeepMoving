package newtenday.login.retrofitjiekou;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by zhangpingzhen on 2018/10/10.
 */

public interface LoginRetrofit {
    @POST("userlogin/query")
    Observable<Object> getLogin(@QueryMap Map<String,String> dedata);
}
