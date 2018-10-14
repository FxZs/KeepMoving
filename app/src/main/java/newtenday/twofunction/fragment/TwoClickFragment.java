package newtenday.twofunction.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.cn.room.activity.R;
import com.jakewharton.rxbinding2.view.RxView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import newtenday.twofunction.adapter.TwoClickAdapter;
import newtenday.twofunction.mounder.TwoClickEntity;
import newtenday.twofunction.presenter.TwoClickPresenter;
import newtenday.twofunction.presenter.TwoClickPresenterImp;
import newtenday.twofunction.view.TwoClickView;

/**
 * Created by Administrator on 2018/10/13.
 */

public class TwoClickFragment extends Fragment implements TwoClickView{
    private RecyclerView two_recy;
    private Button two_btn;
    private TwoClickAdapter twoClickAdapter;
    private Context context;
    private List<TwoClickEntity> lists=new ArrayList<>();
    private TwoClickPresenterImp twoClickPresenterImp;
    private String[] user_name={"test01","test2","test3","test4","test5","test6","test7","test8","test9","test10"};
    private String[] phonesystem={"Android","IOS","Firefox OS","Windows Mobile","ubuntu","Sailfish OS","三星Tizen"};
    private String[] phonetype={"6.5.23","6.1.0","5.5.2","5.0.1","4.1.0","4.2.3","5.7.0","6.2.1"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.newten_twoclick_fragment,container,false);
      context=getActivity();
        twoClickPresenterImp=new TwoClickPresenterImp(this);
       two_recy=view.findViewById(R.id.two_recy);
       DividerItemDecoration decoration=new DividerItemDecoration(context,DividerItemDecoration.VERTICAL);
       decoration.setDrawable(ContextCompat.getDrawable(context,R.drawable.recy_line));
       two_recy.addItemDecoration(decoration);
       two_btn=view.findViewById(R.id.two_btn);
        two_recy.setLayoutManager(new LinearLayoutManager(context));
        twoClickAdapter=new TwoClickAdapter(context,lists);
        two_recy.setAdapter(twoClickAdapter);
        Observer observer=new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object o) {
                insertClickData();
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        RxView.clicks(two_btn).throttleFirst(10, TimeUnit.SECONDS).subscribe(observer);
       return view;
    }
    private void insertClickData() {
        TwoClickEntity twoClickEntity=new TwoClickEntity();
        long four_time,now_time,suijitime;
        Random random=new Random();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
        Calendar c=Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH,-120);
        try {
            four_time=sdf.parse(sdf.format(c.getTime())).getTime();//四个月前的毫秒值
             now_time=System.currentTimeMillis()-four_time;
            suijitime= (long) (four_time+Math.random()*now_time);
            twoClickEntity.setWhatClickTime(sdf.format(new Date(suijitime)));
            twoClickEntity.setTestUser(user_name[random.nextInt(10)]);
             twoClickEntity.setPhoneType(phonetype[random.nextInt(8)]);
             twoClickEntity.setWhichSystem(phonesystem[random.nextInt(7)]);
             twoClickEntity.setWhichThread(Thread.currentThread().getName());
             twoClickEntity.setWhichPage(context.getPackageName());
             twoClickEntity.setWhichMethod("insertClickData");
             twoClickEntity.setBtnText(two_btn.getText().toString());
             twoClickEntity.setWhereBtn(two_btn.getId()+"");
             twoClickPresenterImp.insertTwoClickPresnter(twoClickEntity);

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        twoClickPresenterImp.queryTwoClickPresenter();
    }

    @Override
    public void showTwoClickMsg(List<TwoClickEntity> entities) {
           lists.clear();
           lists.addAll(entities);
           twoClickAdapter.notifyDataSetChanged();
    }

    @Override
    public void setPresenter(TwoClickPresenter presenter) {
           twoClickPresenterImp= (TwoClickPresenterImp) presenter;
    }
}
