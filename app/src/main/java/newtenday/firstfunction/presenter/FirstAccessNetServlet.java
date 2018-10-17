package newtenday.firstfunction.presenter;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.Subject;
import newtenday.firstfunction.dao.FirstAccessTimeDao;
import newtenday.firstfunction.moundle.FristAccessEntity;
import newtenday.http.NewTenHttp;
import newtenday.retrofitjiekou.NewTenRetrofit;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zhangpingzhen on 2018/10/17.
 */

public class FirstAccessNetServlet implements FirstAccessTimePresenter{
    private static String url="http://192.168.8.222:8088/";
    @Override
    public void insertFirstAccessTime(FristAccessEntity fristAccessEntity) {
        Map<String,String> map=new HashMap<>();
        map.put("testUser",fristAccessEntity.getWhichUser());
        map.put("phoneType",fristAccessEntity.getPhoneType());
        map.put("phoneSystem",fristAccessEntity.getWhichSystem());
        map.put("startTime",fristAccessEntity.getStartTime());
        map.put("resurmTime",fristAccessEntity.getResurmTime());
        map.put("totalTime",fristAccessEntity.getTotalTime());
        map.put("threadName",fristAccessEntity.getThreadName());
        map.put("whichPage",fristAccessEntity.getWhichPage());
        NewTenHttp newTenHttp=new NewTenHttp();
        newTenHttp.insert(map,url);
    }

    @Override
    public void queryFirstAccessTime() {

    }

    @Override
    public void delectFirstAccessTime(FristAccessEntity fristAccessEntity) {

    }

    @Override
    public void start() {

    }
}
