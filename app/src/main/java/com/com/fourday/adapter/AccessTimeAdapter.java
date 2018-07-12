package com.com.fourday.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cn.room.activity.R;
import com.com.fourday.AccessTime;

import java.util.List;

/**
 * Created by zhangpingzhen on 2018/7/12.
 */

public class AccessTimeAdapter extends RecyclerView.Adapter<AccessTimeAdapter.ViewHolder>{
    private List<AccessTime> timeList;
    private Context context;

    public AccessTimeAdapter(List<AccessTime> timeList, Context context) {
        this.timeList = timeList;
        this.context = context;
    }

    @Override
    public AccessTimeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.four_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AccessTimeAdapter.ViewHolder holder, int position) {
        AccessTime accessTime=timeList.get(position);
        holder.four_starttime.setText(accessTime.getStartAccess());
        holder.four_stoptime.setText(accessTime.getStopAccess());
    }

    @Override
    public int getItemCount() {
        return timeList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView four_starttime,four_stoptime,four_counttime;
        public ViewHolder(View itemView) {
            super(itemView);
            four_starttime=itemView.findViewById(R.id.four_starttime);
            four_stoptime=itemView.findViewById(R.id.four_stoptime);
            four_counttime=itemView.findViewById(R.id.four_time);
        }
    }
}
