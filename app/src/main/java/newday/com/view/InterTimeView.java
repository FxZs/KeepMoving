package newday.com.view;

import com.fx.base.BaseView;

import java.util.List;

import newday.com.moudle.InterTimeEntity;
import newday.com.presenter.InterTimePresenter;

/**
 * Created by Administrator on 2018/9/10.
 */

public interface InterTimeView extends BaseView<InterTimePresenter> {
    void showMsg(List<InterTimeEntity> interTimeEntities);
}
