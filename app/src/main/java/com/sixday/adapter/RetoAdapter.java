package com.sixday.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cn.room.activity.R;
import com.sixday.moudle.News;

import java.util.List;

/**
 * Created by Administrator on 2018/8/14.
 */

public class RetoAdapter extends RecyclerView.Adapter<RetoAdapter.ViewHolder>{
private List<News> list;
private Context mContext;

    public RetoAdapter(List<News> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView url,body,http,methord,time;
        public  ViewHolder(View itemView){
            super(itemView);
        url=itemView.findViewById(R.id.url);
        body=itemView.findViewById(R.id.body);
        http=itemView.findViewById(R.id.http);
        methord=itemView.findViewById(R.id.methord);
        time=itemView.findViewById(R.id.time);
        }
    }
    @Override
    public RetoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.retor_listtem,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RetoAdapter.ViewHolder holder, int position) {

         News news=list.get(position);
        holder.url.setText(news.getRequestUrl());
        holder.body.setText(news.getRequestMethord());
        holder.http.setTextIsSelectable(news.isIshttp());
        holder.methord.setText(news.getRequestMethord());
        holder.time.setText(news.getRequestTime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
