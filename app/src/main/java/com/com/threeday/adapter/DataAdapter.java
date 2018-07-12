package com.com.threeday.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cn.room.activity.R;
import com.com.threeday.Data;

import java.util.List;

/**
 * Created by zhangpingzhen on 2018/7/12.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder>{
    private List<Data> dataList;
    private Context context;

    public DataAdapter(List<Data> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.three_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
        Data mdata=dataList.get(position);
       holder.three_start.setText(mdata.getOnstarttime());
       holder.three_stop.setText(mdata.getOnresumetime());
    }

    @Override
    public int getItemCount() {

        return dataList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView three_start,three_stop;

        public ViewHolder(View itemView) {
            super(itemView);
            three_start=itemView.findViewById(R.id.three_start);
            three_stop=itemView.findViewById(R.id.three_stop);
        }
    }
}
