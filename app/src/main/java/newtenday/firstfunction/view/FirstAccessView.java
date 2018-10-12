package newtenday.firstfunction.view;

import com.fx.base.BaseView;

import java.util.List;

import newtenday.firstfunction.moundle.FristAccessEntity;
import newtenday.firstfunction.presenter.FirstAccessTimePresenter;

/**
 * Created by zhangpingzhen on 2018/10/12.
 */

public interface FirstAccessView extends BaseView<FirstAccessTimePresenter> {
      void showQueryData(List<FristAccessEntity> fristAccessEntities);
}
