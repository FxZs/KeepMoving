package com.sixday.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cn.room.activity.R;
import com.sixday.moudle.AccessEntity;

import java.util.List;

/**
 * Created by zhangpingzhen on 2018/7/19.
 */

public class SixAccessAdapter extends RecyclerView.Adapter<SixAccessAdapter.ViewHolder>{
    private List<AccessEntity>  entityList;
    private Context mContext;

    private OnmyitemClick onmyitemClick;

    public void setOnmyitemClick(OnmyitemClick onmyitemClick) {
        Log.i("SixAccessAdapter","setOnmyitemClick");
        this.onmyitemClick = onmyitemClick;
    }

    public SixAccessAdapter(List<AccessEntity> entityList, Context mContext) {
        this.entityList = entityList;
        this.mContext = mContext;
    }

    public interface OnmyitemClick{
        void  myClick();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView duqustart,duqustop;
        public  ViewHolder(View itemView){
            super(itemView);
            duqustart=itemView.findViewById(R.id.duqustart);
            duqustop=itemView.findViewById(R.id.duqustop);
        }
    }

    @Override
    public SixAccessAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_base,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SixAccessAdapter.ViewHolder holder, int position) {
        AccessEntity accessEntity=entityList.get(position);
        holder.duqustart.setText(accessEntity.getStartdata());
        holder.duqustop.setText(accessEntity.getPausedata());
        holder.duqustart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if (onmyitemClick!=null){
                onmyitemClick.myClick();
            }
            }
        });
    }



    @Override
    public int getItemCount() {
        return entityList.size();
    }
}
