package newtenday.twofunction.view;

import com.fx.base.BaseView;

import java.util.List;

import newtenday.twofunction.mounder.TwoClickEntity;
import newtenday.twofunction.presenter.TwoClickPresenter;

/**
 * Created by Administrator on 2018/10/13.
 */

public interface TwoClickView extends BaseView<TwoClickPresenter>{
    void showTwoClickMsg(List<TwoClickEntity> entities);
}
