package newtwoday.com.fragment;

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

import java.util.ArrayList;
import java.util.List;

import newtwoday.com.adapter.OnClickAdapter;
import newtwoday.com.moudle.OnclickTimesNum;
import newtwoday.com.presenter.OnClickPresenter;
import newtwoday.com.presenter.OnClickTimesNumPresenterImp;
import newtwoday.com.toos.ButtonUtils;
import newtwoday.com.view.OnClickTimesView;

/**
 * Created by Administrator on 2018/9/10.
 */

public class OnclickTimeNumFragment extends Fragment implements OnClickTimesView {
    private RecyclerView recy_onclick;
    private List<OnclickTimesNum> lists=new ArrayList<>();
    private Context context;
    private OnClickAdapter onClickAdapter;
    private OnClickTimesNumPresenterImp onClickTimesNumPresenterImp;
    private Button onclick_btn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.onclicktime_fragment,container,false);
        context=getActivity();
        recy_onclick=view.findViewById(R.id.recy_onclick);
         recy_onclick.setLayoutManager(new LinearLayoutManager(context));
         onClickAdapter=new OnClickAdapter(lists,context);
         recy_onclick.setAdapter(onClickAdapter);
        onclick_btn=view.findViewById(R.id.onclick_btn);
        onclick_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!ButtonUtils.isFastDoubleClick(R.id.onclick_btn)) {
                    OnclickTimesNum onclickTimesNum=new OnclickTimesNum();
                    onclickTimesNum.setOnclickTimes("000000");
                    onclickTimesNum.setWhichmethod("2010111");
                    onClickTimesNumPresenterImp.insertOnClickPresenter(onclickTimesNum);
                }
            }
        });
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onResume() {
        super.onResume();
        onClickTimesNumPresenterImp.queryOnClickPresenter();
    }

    @Override
    public void showMsg(List<OnclickTimesNum> onclickTimesNums) {
     lists.clear();
     lists.addAll(onclickTimesNums);
     onClickAdapter.notifyDataSetChanged();
    }

    @Override
    public void setPresenter(OnClickPresenter presenter) {
       onClickTimesNumPresenterImp= (OnClickTimesNumPresenterImp) presenter;
    }
}
