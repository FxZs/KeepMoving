package newthreeday.com.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cn.room.activity.R;

import java.util.List;

import newthreeday.com.moudle.CatchHandleEntity;

/**
 * Created by zhangpingzhen on 2018/9/12.
 */

public class CatchHandleAdapter extends RecyclerView.Adapter<CatchHandleAdapter.ViewHolder>{
    private List<CatchHandleEntity> list;
    private Context mContext;

    public CatchHandleAdapter(List<CatchHandleEntity> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView catch_time,catch_method,catch_what,catch_user,catch_phone,catch_type;
        public ViewHolder(View itemView) {
            super(itemView);
            catch_time=itemView.findViewById(R.id.catch_time);
            catch_method=itemView.findViewById(R.id.catch_method);
            catch_what=itemView.findViewById(R.id.catch_what);
            catch_user=itemView.findViewById(R.id.catch_user);
            catch_phone=itemView.findViewById(R.id.catch_phone);
            catch_type=itemView.findViewById(R.id.catch_type);

        }
    }

    @Override
    public CatchHandleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.catch_handle_listitem,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CatchHandleAdapter.ViewHolder holder, int position) {
      CatchHandleEntity catchHandleEntity=list.get(position);
      holder.catch_time.setText(catchHandleEntity.getCatchTime());
      holder.catch_method.setText(catchHandleEntity.getWhichMethod());
      holder.catch_what.setText(catchHandleEntity.getWhatHandle());
      holder.catch_user.setText(catchHandleEntity.getWhichUse());
      holder.catch_phone.setText(catchHandleEntity.getAndroidos());
      holder.catch_type.setText(catchHandleEntity.getPhoneType());
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
