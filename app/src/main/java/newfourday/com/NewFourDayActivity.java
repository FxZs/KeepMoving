package newfourday.com;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.cn.room.activity.App;
import com.cn.room.activity.R;
import com.com.fourday.dao.AccessTimeDao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2018/9/12.
 */

public class NewFourDayActivity extends AppCompatActivity implements View.OnClickListener{
    private NewAccessDao newAccessDao;
    private String nowTime;
    private String beforeFourTime;
    private Button new_insertaccess;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fouractivity_main);
        initView();
    }

    private void initView() {
        new_insertaccess=findViewById(R.id.new_insertaccess);
        new_insertaccess.setOnClickListener(this);
        newAccessDao= App.getFourdatabase().newAccessDao();
    }

    private void Comparaent() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //获取当前时间
        Date date = new Date(System.currentTimeMillis());
      String a= simpleDateFormat.format(date);

    }
    /**
     * 获取前n天日期、后n天日期
     *
     * @param distanceDay 前几天 如获取前7天日期则传-7即可；如果后7天则传7
     * @return
     */
    public static String getOldDate(int distanceDay) {
        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = new Date();
        Calendar date = Calendar.getInstance();
        date.setTime(beginDate);
        date.set(Calendar.DATE, date.get(Calendar.DATE) + distanceDay);
        Date endDate = null;
        try {
            endDate = dft.parse(dft.format(date.getTime()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //LogUtil.d("前7天==" + dft.format(endDate));
        return dft.format(endDate);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.new_insertaccess:
                getOldDate(-120);
                break;
        }
    }
}
