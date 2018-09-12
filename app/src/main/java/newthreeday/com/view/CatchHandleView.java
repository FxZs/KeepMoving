package newthreeday.com.view;

import com.fx.base.BaseView;

import java.util.List;

import newthreeday.com.moudle.CatchHandleEntity;
import newthreeday.com.presenter.CatchHandlePresenter;

/**
 * Created by zhangpingzhen on 2018/9/12.
 */

public interface CatchHandleView extends BaseView<CatchHandlePresenter>{
    void showCatchHandle(List<CatchHandleEntity> catchHandleEntities);
}
