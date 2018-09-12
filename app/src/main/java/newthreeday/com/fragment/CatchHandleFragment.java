package newthreeday.com.fragment;

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

import newthreeday.com.adapter.CatchHandleAdapter;
import newthreeday.com.moudle.CatchHandleEntity;
import newthreeday.com.presenter.CatchHandlePresenter;
import newthreeday.com.presenter.CatchHanldePresenterImp;
import newthreeday.com.view.CatchHandleView;

/**
 * Created by zhangpingzhen on 2018/9/12.
 */

public class CatchHandleFragment extends Fragment implements CatchHandleView,View.OnClickListener{
    private List<CatchHandleEntity> lists=new ArrayList<>();
    private Context context;
    private CatchHanldePresenterImp catchHanldePresenterImp;
    private CatchHandleAdapter catchHandleAdapter;
    private RecyclerView catch_recy;
    private Button catch_btn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.catchhandle_fragment,container,false);
       context=getActivity();
       catch_recy=view.findViewById(R.id.catch_recy);
       catch_btn=view.findViewById(R.id.catch_btn);
       catch_recy.setLayoutManager(new LinearLayoutManager(context));
       catchHandleAdapter=new CatchHandleAdapter(lists,context);
       catch_recy.setAdapter(catchHandleAdapter);
       catch_btn.setOnClickListener(this);
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
        catchHanldePresenterImp.queryCatchHandlepre();
    }

    @Override
    public void showCatchHandle(List<CatchHandleEntity> catchHandleEntities) {
       lists.clear();
       lists.addAll(catchHandleEntities);
       catchHandleAdapter.notifyDataSetChanged();
    }

    @Override
    public void setPresenter(CatchHandlePresenter presenter) {
      catchHanldePresenterImp= (CatchHanldePresenterImp) presenter;
    }

    @Override
    public void onClick(View view) {
     switch (view.getId()){
         case R.id.catch_btn:
             String a = null;
             a.charAt(0);
             break;
     }
    }
}
