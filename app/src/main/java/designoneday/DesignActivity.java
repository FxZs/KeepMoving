package designoneday;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.cn.room.activity.R;

/**
 * Created by Administrator on 2018/9/30.
 */

public class DesignActivity extends AppCompatActivity{
    private Context context;
    private TextView text_view;
    private CoordinatorLayout coor;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.designoneday_activity);
        context=this;
         ininView();
    }

    private void ininView() {
        coor=findViewById(R.id.coor);
        Snackbar.make(coor,"repalace welcome shanghai",Snackbar.LENGTH_LONG).setAction("Action",null).show();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}
