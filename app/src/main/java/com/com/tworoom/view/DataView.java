package com.com.tworoom.view;

import com.com.tworoom.MyUser;
import com.fx.base.BaseView;

import java.util.List;

/**
 * Created by zhangpingzhen on 2018/7/11.
 * 想想view需要做的事情  1.收集数据 2.显示出来
 * 然后定义接口
 */

public interface DataView extends BaseView{
    //之前那个view写的是show....()，相当于提示登录成功，登录失败，网络问题等，现在都不需要提示什么的，
    //这个view是要显示开始访问时间  结束访问时间   总访问时间么？
    //嗯，因为你现在都在一个实体类里面写着，所以一个showDate 搞定 好
//    MyUser getData(); //返回的是封装好的实体类，那个？改下void 啥意思
    // 你收集的数据封装再那个实体类  其实这个不写也行，先忽略他吧,下一步再解释

    // public String startdata;
//    public String stopdata;
//    public String alldata;
    //是不是要显示这三个属性？嗯  这三个属性是不是再myuser 里面。嗯 直接通过get方法拿
    void showData(List<MyUser> time);//这个就是显示你收集到的数据  或者说是界面上需要显示的东西
}//这块不是显示的是时间么   时间
