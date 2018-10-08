package rxjavalian.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Administrator on 2018/10/8.
 */
@Entity
public class RxjavaEntity {
    @PrimaryKey
    private int id;

    private String name;
    private String number;

}
