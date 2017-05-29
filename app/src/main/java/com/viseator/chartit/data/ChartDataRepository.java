package com.viseator.chartit.data;

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
    public List<? extends Entry> getData(Long createTime) {
        return mLocalChartData.getData(createTime);
    }

    private ChartDataRepository(IDataSource localChartData) {
        mLocalChartData = localChartData;
    }


    @Override
    public long addData(List<? extends Entry> entries, String label) {
        return mLocalChartData.addData(entries, label);
    }

    @Override
    public void updateData(Long createTime, List<? extends Entry> entries, String label) {
        mLocalChartData.updateData(createTime, entries, label);

    }

    @Override
    public void removeData(Long createTime) {
        mLocalChartData.removeData(createTime);

    }

}
