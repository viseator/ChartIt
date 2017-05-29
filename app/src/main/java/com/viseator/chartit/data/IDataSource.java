package com.viseator.chartit.data;

import com.github.mikephil.charting.interfaces.datasets.IDataSet;

import java.util.List;

/**
 * Created by viseator on 5/29/17.
 * Wu Di
 * Email: viseator@gmail.com
 */

public class IDataSource {
    interface GetDataCallback{
        void onDataLoaded(List<IDataSet> dataSets);
    }


}
