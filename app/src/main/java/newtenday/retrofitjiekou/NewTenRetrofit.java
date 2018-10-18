package newtenday.retrofitjiekou;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by zhangpingzhen on 2018/10/17.
 */

public interface NewTenRetrofit {
    @POST("tenAccess/insert")
    Observable<Object> insertNewTen(@QueryMap Map<String,String> datashuju);

    @POST("tenClick/insert")
    Observable<Object> insertClick(@QueryMap Map<String,String> clickdata);

    @POST("tenHandle/insert")
    Observable<Object> insertHandle(@QueryMap Map<String,String> handledata);
}
