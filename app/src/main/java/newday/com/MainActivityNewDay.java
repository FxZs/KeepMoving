package newday.com;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cn.room.activity.R;
import com.sixday.fragment.AccessTimeFragment;
import com.sixday.presenter.SixAccessPresenterImp;

import newday.com.Fragment.InterTimeFragment;
import newday.com.presenter.InterTimePresenterImp;
import newtwoday.com.fragment.OnclickTimeNumFragment;
import newtwoday.com.presenter.OnClickTimesNumPresenterImp;

/**
 * Created by Administrator on 2018/9/10.
 */

public class MainActivityNewDay extends AppCompatActivity implements View.OnClickListener{
    private LinearLayout ll_home,ll_address;
    private TextView tv_accetime;
    private TextView tv_clicknumber;
    private TextView tv_handle;
    private InterTimeFragment interTimeFragment;
    private OnclickTimeNumFragment onclickTimeNumFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity_newday);
        initView();
        // 初始化并设置当前Fragment
        initFragment(0);
    }

    private void initFragment(int index) {
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        fragmentManager.getFragments().clear();
        // 隐藏所有Fragment
        hideFragment(transaction);
        switch (index){
            case 0:
                if (interTimeFragment==null){
                    interTimeFragment=new InterTimeFragment();
                    transaction.add(R.id.main_fragment,interTimeFragment);
                }else {
                    transaction.show(interTimeFragment);
                }
                new InterTimePresenterImp(interTimeFragment);
                break;
            case 1:
                if (onclickTimeNumFragment==null){
                    onclickTimeNumFragment=new OnclickTimeNumFragment();
                    transaction.add(R.id.main_fragment,onclickTimeNumFragment);
                }else {
                    transaction.show(onclickTimeNumFragment);
                }
                new OnClickTimesNumPresenterImp(onclickTimeNumFragment);
                break;
        }
        transaction.commit();
    }

    private void initView() {
        ll_home=findViewById(R.id.ll_home);
        ll_home.setOnClickListener(this);
        ll_address=findViewById(R.id.ll_address);
        ll_address.setOnClickListener(this);
        // 底部菜单4个菜单标题
        tv_accetime = (TextView) findViewById(R.id.tv_home);
        tv_clicknumber = (TextView) findViewById(R.id.tv_address);

    }
    private void hideFragment(FragmentTransaction transaction) {
        if (interTimeFragment!=null){
            transaction.hide(interTimeFragment);
        }
        if (onclickTimeNumFragment!=null){
            transaction.hide(onclickTimeNumFragment);
        }

    }

    @Override
    public void onClick(View v) {
switch (v.getId()){
    case R.id.ll_home:
        tv_accetime.setTextColor(0xff1B940A);
        tv_clicknumber.setTextColor((this.getResources().getColor(R.color.colorPrimary)));
        initFragment(0);
        break;
    case R.id.ll_address:
        tv_clicknumber.setTextColor(0xff1B940A);
        tv_accetime.setTextColor((this.getResources().getColor(R.color.colorPrimary)));
        initFragment(1);
        break;
}
    }
}
