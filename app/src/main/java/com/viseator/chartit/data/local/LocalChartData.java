package com.viseator.chartit.data.local;

import com.viseator.chartit.data.ChartDataEntity;
import com.viseator.chartit.data.ChartDataEntityDao;
import com.viseator.chartit.data.IDataSource;

import java.util.List;

/**
 * Created by viseator on 5/29/17.
 * Wu Di
 * Email: viseator@gmail.com
 */

public class LocalChartData implements IDataSource {

    private ChartDataEntityDao mChartDataEntityDao;


    public LocalChartData(ChartDataEntityDao chartDataEntityDao) {
        mChartDataEntityDao = chartDataEntityDao;
    }

    @Override
    public void getData(Long createTime, GetDataCallback callback) {
        List<ChartDataEntity> list = mChartDataEntityDao.queryBuilder()
                .where(ChartDataEntityDao.Properties.Time.eq(createTime)).list();


    }

    @Override
    public void addData(List<?> mainValues, List<?> mapValues) {

    }

    @Override
    public void removeData(Long createTime) {

    }

    @Override
    public void updateData(Long createTime, List<?> mainValues, List<?> mapValues) {

    }
}
