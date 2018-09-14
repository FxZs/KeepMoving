package newfourday.com.view;

import com.fx.base.BaseView;

import java.util.List;

import entity.AccessTimeEntity;
import newfourday.com.presenter.FourPresenter;

/**
 * Created by zhangpingzhen on 2018/9/14.
 */

public interface FourView extends BaseView<FourPresenter>{
    void showMeg(List<AccessTimeEntity> accessTimeEntities);
}
