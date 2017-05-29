package com.viseator.chartit.data;

import com.github.mikephil.charting.data.Entry;

import java.util.List;

/**
 * Created by viseator on 5/29/17.
 * Wu Di
 * Email: viseator@gmail.com
 */

public class ChartDataRepository implements IDataSource {
    private IDataSource mLocalChartData;

    public ChartDataRepository(IDataSource localChartData) {
        mLocalChartData = localChartData;
    }

    @Override

    public void getData(Long createTime, GetDataCallback callback) {
        mLocalChartData.getData(createTime, callback);
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
