package rxjavalian.aa;


import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rxjavalian.entity.RxjavaEntity;

/**
 * Created by zhangpingzhen on 2018/10/9.
 */

public interface WeatherService {
    @GET("weather_mini")
    Observable<RxjavaEntity> getmsg(@Query("city") String city);
}
