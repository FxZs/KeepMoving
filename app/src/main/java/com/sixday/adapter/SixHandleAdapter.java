package com.sixday.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cn.room.activity.R;
import com.sixday.moudle.HandleEntity;

import java.util.List;

/**
 * Created by zhangpingzhen on 2018/7/19.
 */

public class SixHandleAdapter extends RecyclerView.Adapter<SixHandleAdapter.ViewHolder>{
    private List<HandleEntity> listhandle;
    private Context context;

    public SixHandleAdapter(List<HandleEntity> listhandle, Context context) {
        this.listhandle = listhandle;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView decribe,wherethread,threadtime;
        public ViewHolder(View itemview){
            super(itemview);
            decribe=itemview.findViewById(R.id.decribe);
            wherethread=itemview.findViewById(R.id.wherethread);
            threadtime=itemview.findViewById(R.id.threadtime);
        }
    }
    @Override
    public SixHandleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.newfivew_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SixHandleAdapter.ViewHolder holder, int position) {
        HandleEntity handleEntity=listhandle.get(position);
        holder.decribe.setText(handleEntity.getHandleMessage());
        holder.threadtime.setText(handleEntity.getErrorHandleTime());
        holder.wherethread.setText(handleEntity.getWhichThread());

    }

    @Override
    public int getItemCount() {
        return listhandle.size();
    }
}
