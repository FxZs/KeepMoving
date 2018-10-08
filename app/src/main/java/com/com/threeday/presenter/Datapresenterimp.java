package com.com.threeday.presenter;

import com.cn.room.activity.App;
import com.com.threeday.Data;
import com.com.threeday.sounce.DataLocalSource;
import com.com.threeday.view.DataView;

import org.reactivestreams.Subscription;

import java.util.List;

import io.reactivex.FlowableSubscriber;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by zhangpingzhen on 2018/7/12.
 */
//DataPresenterImp 嗯
public class Datapresenterimp implements DataPresenter{
    private DataView dataview;//能看懂么？ 能看懂么？不知道什么意思 这个写法看懂了么？不懂
    private DataLocalSource dataLocalSource;

    public Datapresenterimp(DataView dataview) {//2 就会走这个构造方法,能懂？嗯
        this.dataview = dataview;//赋值p 里面的 v
        this.dataLocalSource=new DataLocalSource(App.getThreeDataBase().mdatadao());//初始化数据库操作管理类
        dataview.setPresenter(this);//赋值放在这里了 3 dataview是谁？然后调用ThreeDataActivity的setPresenter
        //this 就是 Datapresenterimp呀
    }



    @Override
    public void start() {

    }

    @Override
    public void ManageData(Data data) {
        dataLocalSource.AcountData(data);
    }

    @Override
    public void Duqushuju() {//这样写也行吧
     //dataview.showData(dataLocalSource.ReadData());// p 通过 v 调 v 翻过也一样 整理下重新写这个嗯 注意命名规范
    dataLocalSource.ReadData()
    .subscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())
    .subscribe(new FlowableSubscriber<List<Data>>() {
        @Override
        public void onSubscribe(Subscription s) {

        }

        @Override
        public void onNext(List<Data> data) {
            dataview.showData(data);
        }

        @Override
        public void onError(Throwable t) {

        }

        @Override
        public void onComplete() {

        }
    });

    }
}
