package newtenday.firstfunction.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.cn.room.activity.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import newtenday.firstfunction.adapter.FirstAccessAdapter;
import newtenday.firstfunction.moundle.FristAccessEntity;
import newtenday.firstfunction.presenter.FirstAccessTimePresenter;
import newtenday.firstfunction.presenter.FirstAccessTimePresenterImp;
import newtenday.firstfunction.view.FirstAccessView;

/**
 * Created by zhangpingzhen on 2018/10/12.
 */

public class FirstFunctionFragment extends Fragment implements FirstAccessView,View.OnClickListener{
    private RecyclerView first_recy;
    private FirstAccessAdapter firstAccessAdapter;
    private Context context;
   private List<FristAccessEntity> data=new ArrayList<>();
   private FirstAccessTimePresenterImp firstAccessPresenterImp;
   private Button first_btn;
   private String[] user_name={"test01","test2","test3","test4","test5","test6","test7","test8","test9","test10"};
   private String[] phonesystem={"Android","IOS","Firefox OS","Windows Mobile","ubuntu","Sailfish OS","三星Tizen"};
   private String[] phonetype={"6.5.23","6.1.0","5.5.2","5.0.1","4.1.0","4.2.3","5.7.0","6.2.1"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.newten_firstaccess_fragment,container,false);
      context=getActivity();
      firstAccessPresenterImp=new FirstAccessTimePresenterImp(this);
       first_recy=view.findViewById(R.id.first_recy);
        first_btn=view.findViewById(R.id.first_btn);
        first_btn.setOnClickListener(this);
         first_recy.setLayoutManager(new LinearLayoutManager(context));
         firstAccessAdapter=new FirstAccessAdapter(context,data);
         first_recy.setAdapter(firstAccessAdapter);
          return view;
    }

    private void initView() {

    }

    @Override
    public void onResume() {
        super.onResume();
        firstAccessPresenterImp.queryFirstAccessTime();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public void setPresenter(FirstAccessTimePresenter presenter) {
      firstAccessPresenterImp= (FirstAccessTimePresenterImp) presenter;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.first_btn:
                shujuGeneration();
                break;
        }
    }

    private void shujuGeneration() {
        FristAccessEntity fristAccessEntity=new FristAccessEntity();
        long fourtime,nowtime,suijitime;
        Random random=new Random();
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
        Calendar c=Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH,-120);
        try {
            fourtime=sf.parse(sf.format(c.getTime())).getTime();//四个月前时间的毫秒值
            nowtime=System.currentTimeMillis()-fourtime;
            suijitime= (long) (fourtime+Math.random()*nowtime);//随机生成的时间
            fristAccessEntity.setWhichUser(user_name[random.nextInt(10)]);
            fristAccessEntity.setWhichSystem(phonesystem[random.nextInt(7)]);
            fristAccessEntity.setPhoneType(phonetype[random.nextInt(8)]);
            fristAccessEntity.setStartTime(sf.format(new Date(suijitime)));
           int alltime=random.nextInt(20)+1;//随机生成访问的总时间
           //获取当前时间，获取到的时间类型是long类型的，单位是毫秒
            //在这个基础上加上30分钟：currentTime +=30*60*1000
              long stoptime=suijitime+alltime*60*1000;
              fristAccessEntity.setTotalTime(alltime+"");
              fristAccessEntity.setResurmTime(sf.format(new Date(stoptime)));
              fristAccessEntity.setWhichPage(context.getPackageName());
              fristAccessEntity.setThreadName(Thread.currentThread().getName());
              firstAccessPresenterImp.insertFirstAccessTime(fristAccessEntity);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showQueryData(List<FristAccessEntity> fristAccessEntities) {
        data.clear();
        data.addAll(fristAccessEntities);
        firstAccessAdapter.notifyDataSetChanged();
    }
}
