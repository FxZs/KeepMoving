package newtenday.twofunction.presenter;

import com.cn.room.activity.App;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import newtenday.twofunction.dao.TwoClickDao;
import newtenday.twofunction.mounder.TwoClickEntity;
import newtenday.twofunction.view.TwoClickView;

/**
 * Created by Administrator on 2018/10/13.
 */

public class TwoClickPresenterImp implements TwoClickPresenter {
private TwoClickView twoClickView;
private TwoClickDao twoClickDao;

    public TwoClickPresenterImp(TwoClickView twoClickView) {
        this.twoClickView = twoClickView;
       this.twoClickDao= App.getNewTenDataBase().twoClickDao();
       twoClickView.setPresenter(this);
    }

    @Override
    public void insertTwoClickPresnter(TwoClickEntity twoClickEntity) {
          twoClickDao.insertTwoClick(twoClickEntity);


    }

    @Override
    public void queryTwoClickPresenter() {

        twoClickView.showTwoClickMsg(twoClickDao.queryTwoClickAll());

    }

    @Override
    public void start() {

    }
}
