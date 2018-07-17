package com.com.fourday.presenter;

import com.cn.room.activity.App;
import com.com.fourday.AccessTime;
import com.com.fourday.source.AccessTimeLocalSource;
import com.com.fourday.view.AccessView;

/**
 * Created by zhangpingzhen on 2018/7/12.
 */

public class AccessPresenterImp implements AccessPresenter{
    private AccessTimeLocalSource localSource;
    private AccessView accessView;

    public AccessPresenterImp( AccessView accessView) {
        this.localSource = new AccessTimeLocalSource(App.getAccessTimeBase().accessTimeDao());
        this.accessView = accessView;//这句是构造方法自己生成的  马马虎虎算第一关过了吧 简历上可以加上 mvp 和 room了耶
        this.accessView.setPresenter(this);//忘了这个。。。。写了 写错了 你写哪了？没写
    }

    @Override
    public void manageAccessData(AccessTime accessTime) {
        localSource.accountTime(accessTime);
    }

    @Override
    public void fetchAccessData() {
   accessView.showAccessTime(localSource.readDataTime());
    }

    @Override
    public void clicktimes(AccessTime accessTime) {

    }

    @Override
    public void start() {

    }
}
