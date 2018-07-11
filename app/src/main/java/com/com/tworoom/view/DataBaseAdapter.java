package com.com.tworoom.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cn.room.activity.R;
import com.com.tworoom.MyUser;

import java.util.List;

/**
 * Created by Administrator on 2018/7/11.
 */

public class DataBaseAdapter extends RecyclerView.Adapter<DataBaseAdapter.ViewHolder>{
    private List<MyUser> listdata;

    public DataBaseAdapter(List<MyUser> listdata) {
        this.listdata = listdata;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView duqustart;
        TextView duqustop;

        public ViewHolder(View view) {
            super(view);

            duqustart = (TextView) view.findViewById(R.id.duqustart);
            duqustop = (TextView) view.findViewById(R.id.duqustop);
        }
    }

    @Override
    public DataBaseAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_base,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(DataBaseAdapter.ViewHolder holder, int position) {
        MyUser datauser = listdata.get(position);
        holder.duqustart.setText(datauser.getStartdata());
holder.duqustop.setText(datauser.getStopdata());
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }
}
