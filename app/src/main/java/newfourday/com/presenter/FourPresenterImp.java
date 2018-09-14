package newfourday.com.presenter;

import com.cn.room.activity.App;

import entity.AccessTimeEntity;
import newfourday.com.NewAccessDao;
import newfourday.com.view.FourView;

/**
 * Created by zhangpingzhen on 2018/9/14.
 */

public class FourPresenterImp implements FourPresenter {
    private FourView fourView;
    private NewAccessDao newAccessDao;

    public FourPresenterImp(FourView fourView) {
        this.fourView = fourView;
        this.newAccessDao= App.getFourdatabase().newAccessDao();
        fourView.setPresenter(this);
    }

    @Override
    public void insertFour(AccessTimeEntity accessTimeEntity) {
        newAccessDao.insertNewAccessTime(accessTimeEntity);
    }

    @Override
    public void queryFour() {
   fourView.showMeg(newAccessDao.queryNewAccessTime());
    }

    @Override
    public void start() {

    }
}
