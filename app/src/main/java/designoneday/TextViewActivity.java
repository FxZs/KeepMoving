package designoneday;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.BulletSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.widget.TextView;

import com.cn.room.activity.R;

/**
 * Created by Administrator on 2018/9/30.
 */

public class TextViewActivity extends AppCompatActivity{
    private TextView textview;
    private Context context;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.textview_activity);
        context=this;
        initView();
        String text = String.format("￥%1$s  门市价:￥%2$s", 18.6, 22);

       String a="AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
       String b= "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB";
       String d="DDDDDDDDDDDDDDDDDDDDDDDDhttps://www.jianshu.com/p/c1f21dc2e45f";
       String e="";
       String c=a+"\n"+b+"\n"+e+d;
       c.split("\n");
       SpannableStringBuilder ssb=new SpannableStringBuilder(c);
        int z=text.lastIndexOf("门");

       ssb.setSpan(new RelativeSizeSpan(1.2f),0,a.length(),Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssb.setSpan(new RelativeSizeSpan(1.6f),a.length(),a.length()+b.length(),Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        ssb.setSpan(new BulletSpan(20, Color.RED),a.length()+b.length()+e.length(),c.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textview.setText(ssb);
    }

    private void initView() {
        textview=findViewById(R.id.textview);
    }
}
