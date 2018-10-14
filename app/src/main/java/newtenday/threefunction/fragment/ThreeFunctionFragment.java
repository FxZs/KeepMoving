package newtenday.threefunction.fragment;

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

import newtenday.threefunction.adapter.ThreeFunctionAdapter;
import newtenday.threefunction.moundle.ThreeHandleEntity;
import newtenday.threefunction.presenter.ThreeHandlePresenter;
import newtenday.threefunction.presenter.ThreeHandlePresenterImp;
import newtenday.threefunction.view.ThreeHandleView;

/**
 * Created by Administrator on 2018/10/14.
 */

public class ThreeFunctionFragment extends Fragment implements ThreeHandleView{
    private RecyclerView three_recy;
    private Button three_btn;
    private ThreeHandlePresenterImp threeHandlePresenterImp;
    private ThreeFunctionAdapter threeFunctionAdapter;
    private Context context;
    private List<ThreeHandleEntity> lists=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view=inflater.inflate(R.layout.newten_threehandle_fragment,container,false);
   context=getActivity();
   threeHandlePresenterImp=new ThreeHandlePresenterImp(this);
    three_recy=view.findViewById(R.id.three_recy);
    three_btn=view.findViewById(R.id.three_btn);
    three_recy.setLayoutManager(new LinearLayoutManager(context));
    threeFunctionAdapter=new ThreeFunctionAdapter(lists,context);
    three_recy.setAdapter(threeFunctionAdapter);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        threeHandlePresenterImp.queryThreeHandlePresenter();
    }

    @Override
    public void showThreeHandleMsg(List<ThreeHandleEntity> threeHandleEntities) {
            lists.clear();
            lists.addAll(threeHandleEntities);
            threeFunctionAdapter.notifyDataSetChanged();
    }

    @Override
    public void setPresenter(ThreeHandlePresenter presenter) {

    }
}
