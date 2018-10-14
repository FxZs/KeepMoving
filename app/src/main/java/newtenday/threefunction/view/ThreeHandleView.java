package newtenday.threefunction.view;

import com.fx.base.BaseView;

import java.util.List;

import newtenday.threefunction.moundle.ThreeHandleEntity;
import newtenday.threefunction.presenter.ThreeHandlePresenter;

/**
 * Created by Administrator on 2018/10/14.
 */

public interface ThreeHandleView extends BaseView<ThreeHandlePresenter>{
    void showThreeHandleMsg(List<ThreeHandleEntity> threeHandleEntities);
}
