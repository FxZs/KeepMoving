package rxjavalian.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.util.Log;

import java.util.List;

/**
 * Created by Administrator on 2018/10/8.
 */
public class RxjavaEntity {

    private int status;
    private content content;
    private static  class content{
        private String from;
        private String to;
        private String vendor;
        private String out;
        private int errNo;

    }
    public void show(){
        Log.d("RXJava",content.out);
    }
}
