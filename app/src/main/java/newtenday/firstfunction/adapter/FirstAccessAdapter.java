package newtenday.firstfunction.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cn.room.activity.R;

import java.util.List;

import newtenday.firstfunction.moundle.FristAccessEntity;

/**
 * Created by zhangpingzhen on 2018/10/12.
 */

public class FirstAccessAdapter extends RecyclerView.Adapter<FirstAccessAdapter.ViewHolder>{
    private Context context;
    private List<FristAccessEntity> list;

    public FirstAccessAdapter(Context context, List<FristAccessEntity> list) {
        this.context = context;
        this.list = list;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView first_name,first_starttime,first_stoptime,first_alltime,first_phone,first_phonetype,first_thread,first_page;
        public ViewHolder(View itemView) {
            super(itemView);
            first_name=itemView.findViewById(R.id.first_name);
            first_starttime=itemView.findViewById(R.id.first_starttime);
            first_stoptime=itemView.findViewById(R.id.first_stoptime);
            first_alltime=itemView.findViewById(R.id.first_alltime);
            first_phone=itemView.findViewById(R.id.first_phone);
            first_thread=itemView.findViewById(R.id.first_thread);
            first_page=itemView.findViewById(R.id.first_page);
            first_phonetype=itemView.findViewById(R.id.first_phonetype);
        }
    }

    @Override
    public FirstAccessAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.newten_first_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FirstAccessAdapter.ViewHolder holder, int position) {
        FristAccessEntity fristAccessEntity=list.get(position);
           holder.first_name.setText(fristAccessEntity.getWhichUser());
           holder.first_starttime.setText(fristAccessEntity.getStartTime());
           holder.first_stoptime.setText(fristAccessEntity.getResurmTime());
           holder.first_alltime.setText(fristAccessEntity.getTotalTime());
           holder.first_phone.setText(fristAccessEntity.getPhoneType());
           holder.first_phonetype.setText(fristAccessEntity.getWhichSystem());
           holder.first_thread.setText(fristAccessEntity.getThreadName());
           holder.first_page.setText(fristAccessEntity.getWhichPage());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
