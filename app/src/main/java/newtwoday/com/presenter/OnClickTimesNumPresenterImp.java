package newtwoday.com.presenter;

import com.cn.room.activity.App;

import newtwoday.com.dao.OnclickTimeNumDao;
import newtwoday.com.moudle.OnclickTimesNum;
import newtwoday.com.view.OnClickTimesView;

/**
 * Created by Administrator on 2018/9/10.
 */

public class OnClickTimesNumPresenterImp implements OnClickPresenter{
    private OnClickTimesView onClickTimesView;
    private OnclickTimeNumDao onclickTimeNumDao;

    public OnClickTimesNumPresenterImp(OnClickTimesView onClickTimesView) {
        this.onClickTimesView = onClickTimesView;
        this.onclickTimeNumDao= App.getRetorDatabase().onclickTimeNumDao();
        onClickTimesView.setPresenter(this);
    }

    @Override
    public void insertOnClickPresenter(OnclickTimesNum onclickTimesNum) {
           onclickTimeNumDao.insertOnClickNum(onclickTimesNum);
    }

    @Override
    public void queryOnClickPresenter() {
          onClickTimesView.showMsg(onclickTimeNumDao.queryOnclickNum());
    }

    @Override
    public void start() {

    }
}
