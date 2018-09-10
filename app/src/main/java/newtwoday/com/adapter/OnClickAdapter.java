package newtwoday.com.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cn.room.activity.R;

import java.util.List;

import newtwoday.com.moudle.OnclickTimesNum;

/**
 * Created by Administrator on 2018/9/10.
 */

public class OnClickAdapter extends RecyclerView.Adapter<OnClickAdapter.ViewHolder> {
    private List<OnclickTimesNum> list;
    private Context context;

    public OnClickAdapter(List<OnclickTimesNum> list, Context context) {
        this.list = list;
        this.context = context;
    }

    class ViewHolder  extends  RecyclerView.ViewHolder {
        TextView onclick_times,onclick_method;
        public ViewHolder(View itemView) {
            super(itemView);
            onclick_times=itemView.findViewById(R.id.onclick_times);
            onclick_method=itemView.findViewById(R.id.onclick_method);
        }
    }

    @Override
    public OnClickAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.onclick_list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(OnClickAdapter.ViewHolder holder, int position) {
       OnclickTimesNum onclickTimesNum=list.get(position);
       holder.onclick_times.setText(onclickTimesNum.getOnclickTimes());
       holder.onclick_method.setText(onclickTimesNum.getWhichmethod());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
