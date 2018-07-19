package com.sixday.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cn.room.activity.R;
import com.sixday.moudle.ClickEntity;

import java.util.List;

/**
 * Created by zhangpingzhen on 2018/7/19.
 */

public class SixClickAdapter extends RecyclerView.Adapter<SixClickAdapter.ViewHolder>{
    private List<ClickEntity> list;
    private Context context;

    public SixClickAdapter(List<ClickEntity> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView five_times;
        public  ViewHolder(View itemView){
            super(itemView);
            five_times=itemView.findViewById(R.id.five_times);

        }
    }
    @Override
    public SixClickAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.five_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SixClickAdapter.ViewHolder holder, int position) {
       ClickEntity clickEntity=list.get(position);
       holder.five_times.setText(clickEntity.getClickBtnTime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
