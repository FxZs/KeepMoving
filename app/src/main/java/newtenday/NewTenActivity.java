package newtenday;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.ViewDragHelper;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cn.room.activity.R;

import java.lang.reflect.Field;

import newtenday.firstfunction.fragment.FirstFunctionFragment;
import newtenday.firstfunction.presenter.FirstAccessTimePresenterImp;
import newtenday.threefunction.fragment.ThreeFunctionFragment;
import newtenday.twofunction.fragment.TwoClickFragment;

/**
 * Created by zhangpingzhen on 2018/10/11.
 */

public class NewTenActivity extends AppCompatActivity implements View.OnClickListener{
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
     private Toolbar toolbar;
    LinearLayout contentView ;
    private ActionBarDrawerToggle drawerToggle;
    private boolean flag;
    private FirstFunctionFragment firstFragment;
    private TwoClickFragment twoClickFragment;
    private ThreeFunctionFragment threeFunctionFragment;
    private TextView first_one,first_two,first_three,first_four;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newten_activity);
        initView();
        // 初始化并设置当前Fragment
        initFragment(0);
        drawMethod();

    }

    private void initFragment(int index) {
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        fragmentManager.getFragments().clear();
        // 隐藏所有Fragment
        hideFragment(transaction);
        switch (index){
            case 0:
                first_one.setTextColor(0xff1B940A);
                first_two.setTextColor(Color.parseColor("#686868"));
                first_three.setTextColor(Color.parseColor("#686868"));
                if (firstFragment==null){
                    firstFragment=new FirstFunctionFragment();
                    transaction.add(R.id.newten_frame,firstFragment);
                }else {
                    transaction.show(firstFragment);
                }
                new FirstAccessTimePresenterImp(firstFragment);
                break;
            case 1:
                first_two.setTextColor(0xff1B940A);
                first_one.setTextColor(Color.parseColor("#686868"));
                first_three.setTextColor(Color.parseColor("#686868"));
                if(twoClickFragment==null){
                    twoClickFragment=new TwoClickFragment();
                    transaction.add(R.id.newten_frame,twoClickFragment);
                }else{
                    transaction.show(twoClickFragment);
                }
                break;
            case 2:
                first_three.setTextColor(0xff1B940A);
                first_one.setTextColor(Color.parseColor("#686868"));
                first_two.setTextColor(Color.parseColor("#686868"));
                if(threeFunctionFragment==null){
                    threeFunctionFragment=new ThreeFunctionFragment();
                    transaction.add(R.id.newten_frame,threeFunctionFragment);
                }else{
                    transaction.show(threeFunctionFragment);
                }
                break;
        }
        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction) {
        if (firstFragment!=null){
            transaction.hide(firstFragment);
        }
        if (twoClickFragment!=null){
            transaction.hide(twoClickFragment);
        }
        if(threeFunctionFragment!=null){
            transaction.hide(threeFunctionFragment);
        }
    }

    private void drawMethod() {
        toolbar.setTitle("首页");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        View headerView=navigationView.getHeaderView(0);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.accent:
                        initFragment(0);
                        break;
                    case R.id.click:
                        initFragment(1);
                        break;
                    case R.id.yichang:
                        initFragment(2);
                        break;
                }
                item.setChecked(true);
                drawerLayout.closeDrawer(navigationView);
                return true;
            }
        });
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                //获得侧滑菜单的宽度
                int drawerViewWidth = drawerView.getMeasuredWidth();
                //根据滑动百分比计算内容部分应该向右边移动的距离
                int marginLeft = (int)(drawerViewWidth * slideOffset) ;
                //获得内容部分的View对象（内容View对象是第一个，所以是0）
                contentView = (LinearLayout) drawerLayout.getChildAt(0);
                //修改内容部分的左边距
                contentView.setLeft(marginLeft);
                //解决DrawerLayout不能全屏滑动的问题,displayWidthPercentage传 1，即可实现全屏滑动。
                // 如果你想让右侧菜单也是全屏，只要将对应的 "mLeftDragger" 改为 "mRightDragger"

                setDrawerLeftEdgeSize(NewTenActivity.this,drawerLayout,1);


            }
            private void setDrawerLeftEdgeSize(Activity activity, DrawerLayout drawerLayout,  float displayWidthPercentage) {
                if (activity==null||drawerLayout==null)
                    return;
                try {
                    Field leftDraggerField=drawerLayout.getClass().getDeclaredField("mLeftDragger");
                    leftDraggerField.setAccessible(true);
                    ViewDragHelper leftDragger= (ViewDragHelper) leftDraggerField.get(drawerLayout);
                    // 找到 edgeSizeField 并设置 Accessible 为true
                    Field edgeSizeField = leftDragger.getClass().getDeclaredField("mEdgeSize");
                    edgeSizeField.setAccessible(true);
                    int edgeSize = edgeSizeField.getInt(leftDragger);

                    // 设置新的边缘大小
                    Point displaySize = new Point();
                    activity.getWindowManager().getDefaultDisplay().getSize(displaySize);
                    edgeSizeField.setInt(leftDragger, Math.max(edgeSize, (int) (displaySize.x *
                            displayWidthPercentage)));

                }catch (Exception e){

                }
            }
        });
    }

    private void initView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.activity_na);
        navigationView = (NavigationView) findViewById(R.id.nav);
        toolbar=findViewById(R.id.toolbar);
        first_one=findViewById(R.id.newten_one);
        first_two=findViewById(R.id.newten_two);
        first_three=findViewById(R.id.newten_three);
        first_four=findViewById(R.id.newten_four);
        first_one.setOnClickListener(this);
        first_two.setOnClickListener(this);
        first_three.setOnClickListener(this);
        first_four.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.newten_one:
                first_one.setTextColor(0xff1B940A);
                first_two.setTextColor(Color.parseColor("#686868"));
                first_three.setTextColor(Color.parseColor("#686868"));
                initFragment(0);
                break;
            case R.id.newten_two:
                first_two.setTextColor(0xff1B940A);
                first_one.setTextColor(Color.parseColor("#686868"));
                first_three.setTextColor(Color.parseColor("#686868"));
                initFragment(1);
                break;
            case R.id.newten_three:
                first_three.setTextColor(0xff1B940A);
                first_one.setTextColor(Color.parseColor("#686868"));
                first_two.setTextColor(Color.parseColor("#686868"));
                initFragment(2);
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            if (drawerLayout.isDrawerOpen(navigationView)){
                drawerLayout.closeDrawer(navigationView);
            }else{
                drawerLayout.openDrawer(navigationView);
            }
        }
        return super.onOptionsItemSelected(item);
    }
}

