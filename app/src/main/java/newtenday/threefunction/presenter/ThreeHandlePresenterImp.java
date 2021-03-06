package newtenday.threefunction.presenter;

import com.cn.room.activity.App;

import newtenday.threefunction.dao.ThreeHandleDao;
import newtenday.threefunction.moundle.ThreeHandleEntity;
import newtenday.threefunction.view.ThreeHandleView;

/**
 * Created by Administrator on 2018/10/14.
 */

public class ThreeHandlePresenterImp implements ThreeHandlePresenter {
    private ThreeHandleView threeHandleView;
    private ThreeHandleDao threeHandleDao;
    private ThreeHandleNetServlet threeHandleNetServlet;

    public ThreeHandlePresenterImp(ThreeHandleView threeHandleView) {
        this.threeHandleView = threeHandleView;
        threeHandleDao= App.getNewTenDataBase().threeHandleDao();
        threeHandleNetServlet=new ThreeHandleNetServlet();
    }

    @Override
    public void insertThreeHandlePresenter(ThreeHandleEntity threeHandleEntity) {
         threeHandleDao.insertThreeHandle(threeHandleEntity);
         threeHandleNetServlet.insertThreeHandlePresenter(threeHandleEntity);
    }

    @Override
    public void queryThreeHandlePresenter() {
          threeHandleView.showThreeHandleMsg(threeHandleDao.queryThreeHandle());
    }
}
