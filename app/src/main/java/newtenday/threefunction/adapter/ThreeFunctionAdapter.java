package newtenday.threefunction.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cn.room.activity.R;

import java.util.List;

import newtenday.threefunction.moundle.ThreeHandleEntity;

/**
 * Created by Administrator on 2018/10/14.
 */

public class ThreeFunctionAdapter extends RecyclerView.Adapter<ThreeFunctionAdapter.ViewHolder>{
    private List<ThreeHandleEntity> list;
    private Context context;

    public ThreeFunctionAdapter(List<ThreeHandleEntity> list, Context context) {
        this.list = list;
        this.context = context;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
TextView three_name,three_whathandle,three_handletime,three_whichmethod,three_page,three_phone,three_phonetype,three_thread;
        public ViewHolder(View itemView) {
            super(itemView);
            three_name=itemView.findViewById(R.id.three_name);
            three_whathandle=itemView.findViewById(R.id.three_whathandle);
            three_handletime=itemView.findViewById(R.id.three_handletime);
            three_whichmethod=itemView.findViewById(R.id.three_whichmethod);
            three_page=itemView.findViewById(R.id.three_page);
            three_phone=itemView.findViewById(R.id.three_phone);
            three_phonetype=itemView.findViewById(R.id.three_phonetype);
            three_thread=itemView.findViewById(R.id.three_thread);
        }
    }

    @Override
    public ThreeFunctionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.newten_three_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ThreeFunctionAdapter.ViewHolder holder, int position) {
        ThreeHandleEntity threeHandleEntity=list.get(position);
         holder.three_name.setText(threeHandleEntity.getTestUser());
         holder.three_handletime.setText(threeHandleEntity.getHandleTime());
         holder.three_page.setText(threeHandleEntity.getHandlePage());
         holder.three_phone.setText(threeHandleEntity.getWhichSystem());
         holder.three_phonetype.setText(threeHandleEntity.getPhoneType());
         holder.three_thread.setText(threeHandleEntity.getWhichThread());
         holder.three_whathandle.setText(threeHandleEntity.getWhatHandle());
         holder.three_whichmethod.setText(threeHandleEntity.getHanldeMethod());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
