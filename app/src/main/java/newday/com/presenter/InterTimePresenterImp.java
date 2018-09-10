package newday.com.presenter;

import com.cn.room.activity.App;

import newday.com.moudle.InterTimeEntity;
import newday.com.source.InterTimeLocalSource;
import newday.com.view.InterTimeView;

/**
 * Created by Administrator on 2018/9/10.
 */

public class InterTimePresenterImp implements InterTimePresenter{
    private InterTimeLocalSource interTimeLocalSource;
    private InterTimeView interTimeView;

    public InterTimePresenterImp(InterTimeView interTimeView) {
        this.interTimeView = interTimeView;
        this.interTimeLocalSource=new InterTimeLocalSource(App.getRetorDatabase().interTimeDao());
        interTimeView.setPresenter(this);
    }

    @Override
    public void insertInterTimePresenter(InterTimeEntity interTimeEntity) {
       interTimeLocalSource.insertInterTimeSource(interTimeEntity);
    }

    @Override
    public void queryInterTimePresenter() {
          interTimeView.showMsg(interTimeLocalSource.queryInterSource());
    }

    @Override
    public void start() {

    }
}
