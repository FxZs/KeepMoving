package com.com.fiveday.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cn.room.activity.R;
import com.com.fiveday.OnclickEntity;

import java.util.List;

/**
 * Created by Administrator on 2018/7/14.
 */

public class ClickTimesAdapter extends RecyclerView.Adapter<ClickTimesAdapter.ViewHolder>{
    private List<OnclickEntity> entityList;
    private Context context;

    public ClickTimesAdapter(List<OnclickEntity> entityList, Context context) {
        this.entityList = entityList;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView fivew_times;
        public  ViewHolder(View itemView){
            super(itemView);
            fivew_times=itemView.findViewById(R.id.five_times);
        }
    }

    @Override
    public ClickTimesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.five_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ClickTimesAdapter.ViewHolder holder, int position) {
        OnclickEntity onclickEntity=entityList.get(position);
        holder.fivew_times.setText(onclickEntity.toString());
    }

    @Override
    public int getItemCount() {
        return entityList.size();
    }
}
