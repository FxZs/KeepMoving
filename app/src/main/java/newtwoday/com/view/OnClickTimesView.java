package newtwoday.com.view;

import com.fx.base.BaseView;

import java.util.List;

import newtwoday.com.moudle.OnclickTimesNum;
import newtwoday.com.presenter.OnClickPresenter;

/**
 * Created by Administrator on 2018/9/10.
 */

public interface OnClickTimesView extends BaseView<OnClickPresenter>{
    void showMsg(List<OnclickTimesNum> onclickTimesNums);
}
