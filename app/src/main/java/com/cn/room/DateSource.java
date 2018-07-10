package com.cn.room;

/**
 * Created by zhangpingzhen on 2018/7/10.
 * 2.定义基础接口，操作数据库，插入数据没有成功失败返回值的？暂当做没有吧
 * 这里定义了数据操作的规范，与UserPresenter没有直接联系，
 * 只是UserPresenter 持有他的对象操作数据库而已
 * 理清，区分开，这个真的不难
 */

public interface DateSource {

    void insertUser(User user);
//    start_time stop_time 你已经定义再user 里面了
//    insertUser 是不是已经满足了你下面三个的需求  能看到？能
//    定义接口就是定义规范，实现共用
//    void insertStarttime(User user);
//    void insertStoptime(User user);
//    void insertCounttime(User user);
}
