package newfourday.com.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cn.room.activity.R;

import java.util.List;

import entity.AccessTimeEntity;

/**
 * Created by zhangpingzhen on 2018/9/14.
 */

public class FourAccessAdapter extends RecyclerView.Adapter<FourAccessAdapter.ViewHolder> {
    private List<AccessTimeEntity> list;
    private Context context;

    public FourAccessAdapter(List<AccessTimeEntity> list, Context context) {
        this.list = list;
        this.context = context;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView one,two,three,four,five,six,senven,eigth;
        public ViewHolder(View itemView) {
            super(itemView);
            one=itemView.findViewById(R.id.one);
            two=itemView.findViewById(R.id.two);
            three=itemView.findViewById(R.id.three);
            four=itemView.findViewById(R.id.four);
            five=itemView.findViewById(R.id.five);
            six=itemView.findViewById(R.id.six);
            senven=itemView.findViewById(R.id.senven);
            eigth=itemView.findViewById(R.id.eigth);
        }
    }

    @Override
    public FourAccessAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.fouraccess_list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FourAccessAdapter.ViewHolder holder, int position) {
           AccessTimeEntity accessTimeEntity=list.get(position);
           holder.one.setText(accessTimeEntity.getStartTime());
           holder.two.setText(accessTimeEntity.getResurmTime());
           holder.three.setText(accessTimeEntity.getTotalTime());
           holder.four.setText(accessTimeEntity.getWhichUser());
           holder.five.setText(accessTimeEntity.getPhoneType());
           holder.six.setText(accessTimeEntity.getWhichSystem());
           holder.senven.setText(accessTimeEntity.getThreadName());
           holder.eigth.setText(accessTimeEntity.getWhichPage());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
