package newtwoday.com.dao;

import io.reactivex.Observable;
import newtwoday.com.moudle.OnclickTimesNum;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by zhangpingzhen on 2018/10/9.
 */

public interface RetrofitService {
    @POST
    Observable<OnclickTimesNum> getMessage(@Query("onclickTimes") String onclickTimes);
}
