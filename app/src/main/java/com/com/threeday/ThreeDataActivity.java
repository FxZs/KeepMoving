package com.com.threeday;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.cn.room.activity.NoDoubleClickListener;
import com.cn.room.activity.R;
import com.com.fourday.FourActivity;
import com.com.threeday.adapter.DataAdapter;
import com.com.threeday.presenter.DataPresenter;
import com.com.threeday.presenter.Datapresenterimp;
import com.com.threeday.view.DataView;
import com.fx.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangpingzhen on 2018/7/12.
 */

public class ThreeDataActivity extends AppCompatActivity implements DataView{
    private Datapresenterimp dataImp;//这样两个名字 你起的名字。。。 mvp 还是没吃透。。这个变量名字咋了  难道还要全称
    private RecyclerView recyclerView;
    private DataAdapter madapter;
    private List<Data> lists=new ArrayList<>();
    private Button three_btn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.threedataactivity);
        initView();
        new Datapresenterimp(this);//1 首先在这实例化Datapresenterimp
        madapter=new DataAdapter(lists,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(madapter);
    }

    private void initView() {

        recyclerView=findViewById(R.id.three_view);
        three_btn=findViewById(R.id.three_btn);

    }



    @Override//这是那里没写对，应该是传个Datapresenterimp 类型的参数的 这样就对了，
    // 也可以定义为父类型的,然后强转为子类型   有用到么？4个和一个的时候就要用
    //之前就一直觉得没用到  原来是在最后要用 这个setPresenter？嗯
    //你相信，四个都是插入和查询，共用4个实体类共用一套 v p 是不是少写了很多代码嗯
    //这个 v  p 赋值看懂了么？知道怎么赋值了
    //和前面的都一样，v调 p，p调v 里面的方法
    public void setPresenter(DataPresenter presenter) {//4其实就调的这里 给 view 的 p 赋值  把p赋值给其它的吧   p的值呢
        this.dataImp = (Datapresenterimp) presenter;//这句话意思是后者赋值给前者吧 等号就是赋值哇对呀  就是把present赋值给this.nage sha
    }

    @Override
    protected void onStart() {
        super.onStart();
        Data mData=new Data();
        mData.setOnstarttime("222");
        mData.setOnresumetime("333");
        dataImp.ManageData(mData);// v调 p
    }
    @Override
    protected void onResume() {
        super.onResume();
        dataImp.Duqushuju();// v调 p  不用拼音拼方法名  实在想不出啥名字 毕竟那么多方法 那么多类名  这才几个。。。让人看了就能明白你要干啥
    }

    @Override
    public void showData(List<Data> data) {
        this.lists.clear();
        this.lists.addAll(data);
        madapter.notifyDataSetChanged();
    }

}
