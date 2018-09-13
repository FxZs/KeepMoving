package newfourday.com.base;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.com.fourday.dao.AccessTimeDao;

import entity.AccessTimeEntity;
import entity.ClickListerEntity;
import entity.HandleDealWithEntity;
import newfourday.com.NewAccessDao;

/**
 * Created by Administrator on 2018/9/12.
 */
@Database(entities ={AccessTimeEntity.class, ClickListerEntity.class, HandleDealWithEntity.class} ,version = 1)
public abstract class Fourdatabase extends RoomDatabase{
      public  abstract NewAccessDao newAccessDao();
}