package newday.com.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cn.room.activity.R;

import java.util.List;

import newday.com.moudle.InterTimeEntity;

/**
 * Created by Administrator on 2018/9/10.
 */

public class InterTimeAdapter extends RecyclerView.Adapter<InterTimeAdapter.ViewHolder>{
    private List<InterTimeEntity> list;
    private Context mContext;

    public InterTimeAdapter(List<InterTimeEntity> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView inter_starttime,inter_pausetime,inter_whichmetnod,inter_whichhandle;
        public ViewHolder(View itemView) {
            super(itemView);
            inter_starttime=itemView.findViewById(R.id.inter_starttime);
            inter_pausetime=itemView.findViewById(R.id.inter_pausetime);
            inter_whichmetnod=itemView.findViewById(R.id.inter_whichmetnod);
            inter_whichhandle=itemView.findViewById(R.id.inter_whichhandle);
        }
    }

    @Override
    public InterTimeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.list_item_newday,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(InterTimeAdapter.ViewHolder holder, int position) {
             InterTimeEntity interTimeEntity=list.get(position);
             holder.inter_starttime.setText(interTimeEntity.getStartTime());
             holder.inter_pausetime.setText(interTimeEntity.getPauseTime());
             holder.inter_whichmetnod.setText(interTimeEntity.getWhichmethod());
             holder.inter_whichhandle.setText(interTimeEntity.getWhichhandle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
