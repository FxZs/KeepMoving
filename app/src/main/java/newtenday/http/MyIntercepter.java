package newtenday.http;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by zhangpingzhen on 2018/10/18.
 */

public class MyIntercepter implements Interceptor{
    private static String TAG="newten.MyIntercepter";
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request=chain.request();
        Log.i(TAG,request.url().toString());
        Log.i(TAG,request.method().toString());
        Log.i(TAG,request.isHttps()+"");
        Log.i(TAG,request.body().toString());
         String url= request.url().toString();
         String method=request.method();
          String body= request.body().toString();
          String ishttp=   request.isHttps()+"";

        Response response=chain.proceed(request);

        return response;
    }
}
