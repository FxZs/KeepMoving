package newfourday.com;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.cn.room.activity.App;
import com.cn.room.activity.R;
import com.com.fourday.dao.AccessTimeDao;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2018/9/12.
 */

public class NewFourDayActivity extends AppCompatActivity{
    private AccessTimeDao accessTimeDao;
    private String nowTime;
    private String beforeFourTime;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.fouractivity_main);
        accessTimeDao= App.getFourdatabase().accessTimeDao();
        Comparaent();
    }

    private void Comparaent() {
        nowTime=System.currentTimeMillis()+"";
        Date date=new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -120);
        date = calendar.getTime();
        beforeFourTime=date.toString();

    }
}
