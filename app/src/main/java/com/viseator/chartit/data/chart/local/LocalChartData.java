package com.viseator.chartit.data.chart.local;

import android.util.Log;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;
import com.viseator.chartit.R;
import com.viseator.chartit.data.chart.ChartDataEntity;
import com.viseator.chartit.data.chart.ChartDataEntityDao;
import com.viseator.chartit.data.chart.IDataSource;
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
    public List<? extends Entry> getData(Integer pos) {
        ChartDataEntity data = getChartDataEntityByPos(pos);
        if (data == null) {
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
    public String getLabel(Integer pos) {
        return getChartDataEntityByPos(pos).getLabel();
    }

    @Override
    public void addData(List<? extends Entry> entries, String label) {
        ChartDataEntity chartDataEntity = new ChartDataEntity();
        setEntityByEntries(chartDataEntity, entries);
        chartDataEntity.setLabel(label);
        chartDataEntity.setTime(System.currentTimeMillis());
        chartDataEntity.setPos(count());
        mChartDataEntityDao.insert(chartDataEntity);
    }

    @Override
    public int count() {
        return ((int) mChartDataEntityDao.count());
    }


    @Override
    public void removeData(Integer pos) {
        mChartDataEntityDao.delete(getChartDataEntityByPos(pos));

        List<ChartDataEntity> list = mChartDataEntityDao.queryBuilder()
                .where(ChartDataEntityDao.Properties.Pos.gt(pos)).list();
        for (ChartDataEntity entity : list) {
            entity.setPos(entity.getPos() - 1);
            mChartDataEntityDao.update(entity);
        }
    }

    @Override
    public void removeAllData() {
        mChartDataEntityDao.deleteAll();
    }

    @Override
    public void updateData(Integer pos, List<? extends Entry> entries, String label) {
        ChartDataEntity data = getChartDataEntityByPos(pos);
        if (data == null) {
            return;
        }
        setEntityByEntries(data, entries);
        data.setLabel(label);
        mChartDataEntityDao.update(data);
    }

    private ChartDataEntity getChartDataEntityByPos(Integer pos) {
        List<ChartDataEntity> list = mChartDataEntityDao.queryBuilder()
                .where(ChartDataEntityDao.Properties.Pos.eq(pos)).list();
        if (list.size() < 1) {
            Log.e(TAG, "did not find data! Pos :" + String.valueOf(pos));
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
            // strings
            entity.setType(1);
            entity.setAlias(DataCoverter.stringListToString(aliases));
        } else {
            // floats
            entity.setType(0);
        }

    }
}
