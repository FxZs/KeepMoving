package newtenday.twofunction.presenter;

import com.fx.base.BasePresenter;

import java.util.List;

import newtenday.twofunction.mounder.TwoClickEntity;

/**
 * Created by Administrator on 2018/10/13.
 */

public interface TwoClickPresenter extends BasePresenter{
    void insertTwoClickPresnter(TwoClickEntity twoClickEntity);
   void   queryTwoClickPresenter();
}
