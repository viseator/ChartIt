package com.viseator.chartit.data.local;

import android.util.Log;

import com.github.mikephil.charting.data.Entry;
import com.viseator.chartit.data.ChartDataEntity;
import com.viseator.chartit.data.ChartDataEntityDao;
import com.viseator.chartit.data.IDataSource;
import com.viseator.chartit.utils.DataCoverter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by viseator on 5/29/17.
 * Wu Di
 * Email: viseator@gmail.com
 */

public class LocalChartData implements IDataSource {

    private static LocalChartData INSTANCE = null;
    private static final String TAG = "@vir LocalChartData";
    private ChartDataEntityDao mChartDataEntityDao;


    public static LocalChartData getInstance() {
        return INSTANCE;
    }

    public static LocalChartData getInstance(ChartDataEntityDao chartDataEntityDao) {
        if (INSTANCE == null) {
            INSTANCE = new LocalChartData(chartDataEntityDao);
        }
        return INSTANCE;
    }

    private LocalChartData(ChartDataEntityDao chartDataEntityDao) {
        mChartDataEntityDao = chartDataEntityDao;
    }

    @Override
    public List<? extends Entry> getData(Long createTime) {
        ChartDataEntity data = getChartDataEntityByTime(createTime);
        if (data == null) {
            Log.d(TAG, "NULL!");
            return null;
        }
        List<Float> mainValues = DataCoverter.stringToFloats(data.getMainValue());
        List<Float> mapValues = DataCoverter.stringToFloats(data.getMapValue());
        List<String> aliases = DataCoverter.stringToStringList(data.getAlias());
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < mainValues.size(); i++) {
            Entry entry = new Entry(mainValues.get(i), mapValues.get(i),
                    aliases == null ? null : aliases.get(i));
            entries.add(entry);
        }
        return entries;
    }

    @Override
    public long addData(List<? extends Entry> entries, String label) {
        ChartDataEntity chartDataEntity = new ChartDataEntity();
        setEntityByEntries(chartDataEntity,entries);
        chartDataEntity.setLabel(label);
        chartDataEntity.setTime(System.currentTimeMillis());

        mChartDataEntityDao.insert(chartDataEntity);
        return chartDataEntity.getTime();
    }

    @Override
    public int count() {
        return ((int) mChartDataEntityDao.count());
    }

    @Override
    public void removeData(Long createTime) {
        mChartDataEntityDao.delete(getChartDataEntityByTime(createTime));
    }

    @Override
    public void updateData(Long createTime, List<? extends Entry> entries, String label) {
        ChartDataEntity data = getChartDataEntityByTime(createTime);
        setEntityByEntries(data,entries);
        data.setLabel(label);
    }

    private ChartDataEntity getChartDataEntityByTime(Long createTime) {
        List<ChartDataEntity> list = mChartDataEntityDao.queryBuilder()
                .where(ChartDataEntityDao.Properties.Time.eq(createTime)).list();
        if (list.size() < 1) {
            return null;
        }
        return list.get(0);

    }

    private void setEntityByEntries(ChartDataEntity entity, List<? extends Entry> entries) {
        List<Float> mainValues = new ArrayList<>();
        List<Float> mapValues = new ArrayList<>();
        List<String> aliases = new ArrayList<>();
        for (Entry entry : entries) {
            mainValues.add(entry.getX());
            mapValues.add(entry.getY());
            if (entry.getData() != null) {
                aliases.add((String) (entry.getData()));
            }
        }

        entity.setMainValue(DataCoverter.floatsToString(mainValues));
        entity.setMapValue(DataCoverter.floatsToString(mapValues));
        if (aliases.size() > 0) {
            entity.setAlias(DataCoverter.stringListToString(aliases));
        }

    }
}
