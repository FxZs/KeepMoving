package newtenday.firstfunction.presenter;

import com.cn.room.activity.App;

import java.util.List;

import newtenday.firstfunction.dao.FirstAccessTimeDao;
import newtenday.firstfunction.moundle.FristAccessEntity;
import newtenday.firstfunction.view.FirstAccessView;

/**
 * Created by zhangpingzhen on 2018/10/12.
 */

public class FirstAccessTimePresenterImp implements FirstAccessTimePresenter {
     FirstAccessView firstAccessView;
     FirstAccessTimeDao dao;

    public FirstAccessTimePresenterImp(FirstAccessView firstAccessView) {
        this.firstAccessView = firstAccessView;
        this.dao = App.getNewTenDataBase().firstAccessTimeDao();
        firstAccessView.setPresenter(this);
    }

    @Override
    public void insertFirstAccessTime(FristAccessEntity fristAccessEntity) {
        dao.insertFirstAccess(fristAccessEntity);
    }

    @Override
    public void queryFirstAccessTime() {
        firstAccessView.showQueryData(dao.queryFirstAccess());
    }

    @Override
    public void delectFirstAccessTime(FristAccessEntity fristAccessEntity) {
              dao.delectFirstAccess(fristAccessEntity);
    }

    @Override
    public void start() {

    }
}
