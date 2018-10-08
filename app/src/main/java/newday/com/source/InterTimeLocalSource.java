package newday.com.source;

import java.util.List;

import io.reactivex.Flowable;
import newday.com.dao.InterTimeDao;
import newday.com.moudle.InterTimeEntity;

/**
 * Created by Administrator on 2018/9/10.
 */

public class InterTimeLocalSource implements InterTimeSource{
    private InterTimeDao interTimeDao;

    public InterTimeLocalSource(InterTimeDao interTimeDao) {
        this.interTimeDao = interTimeDao;
    }

    @Override
    public void insertInterTimeSource(InterTimeEntity interTimeEntity) {
            interTimeDao.insertInterTime(interTimeEntity);
    }

    @Override
    public Flowable<List<InterTimeEntity>> queryInterSource() {
        return interTimeDao.queryInterTime();
    }
}
