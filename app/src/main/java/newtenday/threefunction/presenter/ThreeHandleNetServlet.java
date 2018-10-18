package newtenday.threefunction.presenter;

import java.util.HashMap;
import java.util.Map;

import newtenday.http.NewTenHttp;
import newtenday.threefunction.moundle.ThreeHandleEntity;

/**
 * Created by zhangpingzhen on 2018/10/18.
 */

public class ThreeHandleNetServlet implements ThreeHandlePresenter {
    @Override
    public void insertThreeHandlePresenter(ThreeHandleEntity threeHandleEntity) {
        Map<String,String> map=new HashMap<>();
        map.put("testUser",threeHandleEntity.getTestUser());
        map.put("handleTime",threeHandleEntity.getHandleTime());
        map.put("handleMethod",threeHandleEntity.getHanldeMethod());
        map.put("phoneType",threeHandleEntity.getPhoneType());
        map.put("whichSystem",threeHandleEntity.getWhichSystem());
        map.put("whichThread",threeHandleEntity.getWhichThread());
        map.put("handlePage",threeHandleEntity.getHandlePage());
        map.put("whatHandle",threeHandleEntity.getWhatHandle());
        NewTenHttp newTenHttp= new NewTenHttp();
        newTenHttp.insertHandle(map);
    }

    @Override
    public void queryThreeHandlePresenter() {

    }
}
