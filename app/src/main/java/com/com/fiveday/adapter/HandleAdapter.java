package com.com.fiveday.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cn.room.activity.R;
import com.com.fiveday.HandleEntity;

import java.util.List;

/**
 * Created by zhangpingzhen on 2018/7/18.
 */

public class HandleAdapter extends RecyclerView.Adapter<HandleAdapter.ViewHolder>{
    private List<HandleEntity> list;

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView threadtime,wherethread,decribe;
        public  ViewHolder(View itemView){
            super(itemView);
            threadtime=itemView.findViewById(R.id.threadtime);
            wherethread=itemView.findViewById(R.id.wherethread);
            decribe=itemView.findViewById(R.id.decribe);
        }
    }
    @Override
    public HandleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.newfivew_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        HandleEntity handleEntity=list.get(position);
       holder.decribe.setText(handleEntity.getHandleMessage());
       holder.wherethread.setText(handleEntity.getWhichThread());
       holder.threadtime.setText(handleEntity.getErrorTimes());
    }



    @Override
    public int getItemCount() {
        return list.size();
    }
}
