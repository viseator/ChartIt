package com.viseator.chartit.data.chart;

import com.github.mikephil.charting.data.Entry;

import java.util.List;

/**
 * Created by viseator on 5/29/17.
 * Wu Di
 * Email: viseator@gmail.com
 */

public class ChartDataRepository implements IDataSource {
    private static ChartDataRepository INSTANCE = null;
    private IDataSource mLocalChartData;

    @Override
    public int count() {
        return mLocalChartData.count();
    }

    public static ChartDataRepository getInstance() {
        return INSTANCE;
    }
    public static ChartDataRepository getInstance(IDataSource localChartData) {
        if (INSTANCE == null) {
            INSTANCE = new ChartDataRepository(localChartData);
        }
        return INSTANCE;
    }
    @Override
    public List<? extends Entry> getData(Integer pos) {
        return mLocalChartData.getData(pos);
    }

    @Override
    public String getLabel(Integer pos) {
        return mLocalChartData.getLabel(pos);
    }

    private ChartDataRepository(IDataSource localChartData) {
        mLocalChartData = localChartData;
    }


    @Override
    public void addData(List<? extends Entry> entries, String label) {
        mLocalChartData.addData(entries, label);
    }

    @Override
    public void updateData(Integer pos, List<? extends Entry> entries, String label) {
        mLocalChartData.updateData(pos, entries, label);

    }

    @Override
    public void removeData(Integer pos) {
        mLocalChartData.removeData(pos);
    }

    @Override
    public void removeAllData() {
        mLocalChartData.removeAllData();
    }

}
