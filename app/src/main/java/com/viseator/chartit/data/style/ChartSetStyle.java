package com.viseator.chartit.data.style;

import com.viseator.chartit.data.chart.ChartDataEntity;
import com.viseator.chartit.data.chart.ChartDataEntityDao;

import java.util.List;

/**
 * Created by viseator on 5/31/17.
 * Wu Di
 * Email: viseator@gmail.com
 */

public class ChartSetStyle {

    private ChartSetStyleEntityDao mChartSetStyleEntityDao;

    public ChartSetStyle(ChartSetStyleEntityDao chartSetStyleEntityDao) {
        mChartSetStyleEntityDao = chartSetStyleEntityDao;
    }

    public ChartSetStyleEntity getChartSetStyle(int pos) {
        return mChartSetStyleEntityDao.queryBuilder().where
                (ChartSetStyleEntityDao.Properties.Position.eq(pos)).list().get(0);
    }

    public List<ChartSetStyleEntity> getAllChartSetStyles() {
        return mChartSetStyleEntityDao.queryBuilder().list();
    }

    public void addChartSetStyleEntity(ChartSetStyleEntity chartSetStyleEntity) {
        chartSetStyleEntity.setPosition(count());
        mChartSetStyleEntityDao.insert(chartSetStyleEntity);
    }

    public void removeChartSetStyleEntity(int pos) {
        mChartSetStyleEntityDao.delete(getChartSetStyle(pos));
        List<ChartSetStyleEntity> list = mChartSetStyleEntityDao.queryBuilder()
                .where(ChartDataEntityDao.Properties.Pos.gt(pos)).list();
        for (ChartSetStyleEntity entity : list) {
            entity.setPosition(entity.getPosition() - 1);
            mChartSetStyleEntityDao.update(entity);
        }
    }

    public void updateChartSetStyleEntity(ChartSetStyleEntity chartSetStyleEntity) {
        mChartSetStyleEntityDao.update(chartSetStyleEntity);
    }

    public int count() {
        return (int) mChartSetStyleEntityDao.count();
    }

}
