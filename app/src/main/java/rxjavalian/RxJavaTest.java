package rxjavalian;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.cn.room.activity.R;


/**
 * Created by Administrator on 2018/10/8.
 */

public class RxJavaTest extends AppCompatActivity implements View.OnClickListener{
    private RecyclerView recy_rx;
    private LinearLayout lin_one,lin_two,lin_three;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rxjava_activity);
        initView();
    }

    private void initView() {
        recy_rx=findViewById(R.id.recy_rx);
        lin_one=findViewById(R.id.textone);
        lin_two=findViewById(R.id.texttwo);
        lin_three=findViewById(R.id.textthree);
        lin_one.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
