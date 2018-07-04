package com.fx.view;

import com.fx.base.BaseView;

/**
 * Created by zhangpingzhen on 2018/7/3.
 * 登录View需要做的就是将结果进行ui展示
 * 现在需要的 m v p 都有了，组织在一起就好了
 */

public interface LoginView  extends BaseView{
    void showLoginResult(String result);
}
