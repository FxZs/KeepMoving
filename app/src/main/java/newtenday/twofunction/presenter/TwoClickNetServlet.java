package newtenday.twofunction.presenter;

import java.util.HashMap;
import java.util.Map;

import newtenday.http.NewTenHttp;
import newtenday.twofunction.mounder.TwoClickEntity;

/**
 * Created by zhangpingzhen on 2018/10/18.
 */

public class TwoClickNetServlet implements TwoClickPresenter{
    @Override
    public void insertTwoClickPresnter(TwoClickEntity twoClickEntity) {
        Map<String,String> map=new HashMap<>();
        map.put("testUser",twoClickEntity.getTestUser());
        map.put("btnText",twoClickEntity.getBtnText());
        map.put("phoneType",twoClickEntity.getPhoneType());
        map.put("clickTime",twoClickEntity.getWhatClickTime());
        map.put("whichSystem",twoClickEntity.getWhichSystem());
        map.put("whereBtn",twoClickEntity.getWhereBtn());
        map.put("whichMethod",twoClickEntity.getWhichMethod());
        map.put("whichThread",twoClickEntity.getWhichThread());
        map.put("whichPage",twoClickEntity.getWhichPage());
        NewTenHttp tenHttp=new NewTenHttp();
        tenHttp.insertClick(map);
    }

    @Override
    public void queryTwoClickPresenter() {

    }

    @Override
    public void start() {

    }
}
