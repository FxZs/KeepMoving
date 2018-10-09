package rxjavalian.entity;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by zhangpingzhen on 2018/10/9.
 */

public interface GetRequest_Interface {
    @GET("ajax.php?a=fy&f=auto&t=auto&w=hi%20world")
    Observable<RxjavaEntity> getCall();}

