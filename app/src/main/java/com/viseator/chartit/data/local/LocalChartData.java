package com.viseator.chartit.data.local;

import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.viseator.chartit.data.ChartDataEntity;
import com.viseator.chartit.data.ChartDataEntityDao;
import com.viseator.chartit.data.IDataSource;
import com.viseator.chartit.utils.DataCoverter;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;

import java.util.ArrayList;
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
        ChartDataEntity data = list.get(0);
        List<Float> mainValues = DataCoverter.stringToFloats(data.getMainValue());
        List<Float> mapValues = DataCoverter.stringToFloats(data.getMapValue());
        List<String> aliases = DataCoverter.stringToStringList(data.getAlias());
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < mainValues.size(); i++) {
            Entry entry = new Entry(mainValues.get(i), mapValues.get(i),
                    aliases == null ? null: aliases.get(i));
            entries.add(entry);
        }
//        callback.onDataLoaded(new DataSet(entries,null));



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
