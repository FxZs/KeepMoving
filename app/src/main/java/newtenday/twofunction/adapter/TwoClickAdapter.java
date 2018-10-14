package newtenday.twofunction.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cn.room.activity.R;

import java.util.List;

import newtenday.twofunction.mounder.TwoClickEntity;

/**
 * Created by Administrator on 2018/10/13.
 */

public class TwoClickAdapter extends RecyclerView.Adapter<TwoClickAdapter.ViewHolder> {
    private Context context;
    private List<TwoClickEntity> list;

    public TwoClickAdapter(Context context, List<TwoClickEntity> list) {
        this.context = context;
        this.list = list;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView two_name,two_starttime,two_wherebtn,two_text,two_methord,two_phonesystem,two_phonetype,two_thread,two_page;
        public ViewHolder(View itemView) {
            super(itemView);
            two_name=itemView.findViewById(R.id.two_name);
            two_starttime=itemView.findViewById(R.id.two_starttime);
            two_wherebtn=itemView.findViewById(R.id.two_wherebtn);
            two_text=itemView.findViewById(R.id.two_text);
            two_methord=itemView.findViewById(R.id.two_methord);
            two_phonesystem=itemView.findViewById(R.id.two_phonesystem);
            two_phonetype=itemView.findViewById(R.id.two_phonetype);
            two_thread=itemView.findViewById(R.id.two_thread);
            two_page=itemView.findViewById(R.id.two_page);
        }
    }

    @Override
    public TwoClickAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.newten_two_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TwoClickAdapter.ViewHolder holder, int position) {
              TwoClickEntity twoClickEntity=list.get(position);
              holder.two_name.setText(twoClickEntity.getTestUser());
              holder.two_starttime.setText(twoClickEntity.getWhatClickTime());
              holder.two_text.setText(twoClickEntity.getBtnText());
              holder.two_methord.setText(twoClickEntity.getWhichMethod());
              holder.two_wherebtn.setText(twoClickEntity.getWhereBtn());
              holder.two_phonetype.setText(twoClickEntity.getPhoneType());
              holder.two_phonesystem.setText(twoClickEntity.getWhichSystem());
              holder.two_thread.setText(twoClickEntity.getWhichThread());
              holder.two_page.setText(twoClickEntity.getWhichPage());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
