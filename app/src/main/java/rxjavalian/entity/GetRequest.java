package rxjavalian.entity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.cn.room.activity.R;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zhangpingzhen on 2018/10/9.
 */

public class GetRequest extends AppCompatActivity{
    private static final String TAG = "Rxjava";
    private int i=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
setContentView(R.layout.rxjava_activity);
        request();
        a();
    }

    private void a() {

        Observable.interval(500,TimeUnit.MILLISECONDS)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.e("TAGaaa", "" + aLong);
                    }
                });

    }

    private void request() {
      Retrofit retrofit=new Retrofit.Builder()
              .baseUrl("http://fy.iciba.com/")
              .addConverterFactory(GsonConverterFactory.create())
              .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
              .build();
      GetRequest_Interface getRequest_interface=retrofit.create(GetRequest_Interface.class);
      getRequest_interface.getCall()
              .repeatWhen(new Function<Observable<Object>, ObservableSource<?>>() {
                  @Override
                  public ObservableSource<?> apply(Observable<Object> objectObservable) throws Exception {
                      return objectObservable.flatMap(new Function<Object, ObservableSource<?>>() {
                          @Override
                          public ObservableSource<?> apply(Object o) throws Exception {
                             if(i>3){
                                 return Observable.error(new Throwable("结束"));
                             }

                              return Observable.just(1).delay(2000, TimeUnit.MILLISECONDS);
                          }
                      });

                  }
              })
              .subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread())
              .subscribe(new Observer<RxjavaEntity>() {
                  @Override
                  public void onSubscribe(Disposable d) {

                  }

                  @Override
                  public void onNext(RxjavaEntity rxjavaEntity) {
                         rxjavaEntity.show();
                         i++;
                  }

                  @Override
                  public void onError(Throwable e) {

                  }

                  @Override
                  public void onComplete() {

                  }
              });
    }
}
