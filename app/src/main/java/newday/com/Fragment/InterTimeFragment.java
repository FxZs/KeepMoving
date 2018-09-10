package newday.com.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cn.room.activity.R;

import java.util.ArrayList;
import java.util.List;

import newday.com.adapter.InterTimeAdapter;
import newday.com.moudle.InterTimeEntity;
import newday.com.presenter.InterTimePresenter;
import newday.com.presenter.InterTimePresenterImp;
import newday.com.view.InterTimeView;

/**
 * Created by Administrator on 2018/9/10.
 */

public class InterTimeFragment extends Fragment  implements InterTimeView{
private RecyclerView recy_newday;
private InterTimeAdapter timeAdapter;
private List<InterTimeEntity> lists=new ArrayList<>();
private InterTimePresenterImp interTimePresenterImp;
private Context context;
private String TAG=InterTimeFragment.class.getName();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.newday_fragment,container,false);
       context=getActivity();
       recy_newday=view.findViewById(R.id.recy_newday);
       recy_newday.setLayoutManager(new LinearLayoutManager(context));
       timeAdapter=new InterTimeAdapter(lists,context);
       recy_newday.setAdapter(timeAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        InterTimeEntity interTimeEntity=new InterTimeEntity();
        interTimeEntity.setStartTime("200000");
        interTimeEntity.setPauseTime("211111");
        interTimeEntity.setWhichmethod(TAG);
        interTimeEntity.setWhichhandle("000");
        interTimePresenterImp.insertInterTimePresenter(interTimeEntity);
    }

    @Override
    public void onResume() {
        super.onResume();
        interTimePresenterImp.queryInterTimePresenter();
    }

    @Override
    public void showMsg(List<InterTimeEntity> interTimeEntities) {
         lists.clear();
         lists.addAll(interTimeEntities);
         timeAdapter.notifyDataSetChanged();
    }

    @Override
    public void setPresenter(InterTimePresenter presenter) {
interTimePresenterImp= (InterTimePresenterImp) presenter;
    }
}
