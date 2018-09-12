package newthreeday.com.presenter;

import com.cn.room.activity.App;

import java.util.List;

import newthreeday.com.dao.CatchHandleDao;
import newthreeday.com.moudle.CatchHandleEntity;
import newthreeday.com.view.CatchHandleView;

/**
 * Created by zhangpingzhen on 2018/9/12.
 */

public class CatchHanldePresenterImp implements CatchHandlePresenter{
    private CatchHandleView catchHandleView;
    private CatchHandleDao catchHandleDao;

    public CatchHanldePresenterImp(CatchHandleView catchHandleView) {
        this.catchHandleView = catchHandleView;
        this.catchHandleDao= App.getRetorDatabase().catchHandleDao();
        catchHandleView.setPresenter(this);
    }

    @Override
    public void insertCatchHandlepre(CatchHandleEntity catchHandleEntity) {
      catchHandleDao.insertCatchHandle(catchHandleEntity);
    }

    @Override
    public void queryCatchHandlepre() {
        catchHandleView.showCatchHandle(catchHandleDao.queryCatchHandle());
    }

    public void start() {
        queryCatchHandlepre();
    }

}
