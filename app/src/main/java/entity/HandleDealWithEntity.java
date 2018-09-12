package entity;

/**
 * Created by zhangpingzhen on 2018/9/12.
 */

public class HandleDealWithEntity {
    private int id;
    private String whatHandle;//什么异常
    private String handleTime;//产生异常时间
    private String hanldeMethod;//哪个方法里面异常
    private String handlePage;//异常产生的当前页面
    private String testUser;
    private String whichCaozuo;//什么操作导致的异常
    private String phoneType;//什么机型
    private String whichSystem;//什么系统
    private boolean isMainThread;//是否主线程
}
