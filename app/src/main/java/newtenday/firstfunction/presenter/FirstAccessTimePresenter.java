package newtenday.firstfunction.presenter;

import com.fx.base.BasePresenter;

import java.util.List;

import io.reactivex.Flowable;
import newtenday.firstfunction.moundle.FristAccessEntity;

/**
 * Created by zhangpingzhen on 2018/10/12.
 */

public interface FirstAccessTimePresenter extends BasePresenter{
    void insertFirstAccessTime(FristAccessEntity fristAccessEntity);
    void queryFirstAccessTime();
    void delectFirstAccessTime(FristAccessEntity fristAccessEntity);
}
