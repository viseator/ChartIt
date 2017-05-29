package com.viseator.chartit.data;

import com.github.mikephil.charting.data.Entry;

import java.util.List;

/**
 * Created by viseator on 5/29/17.
 * Wu Di
 * Email: viseator@gmail.com
 */

public interface IDataSource {
    interface GetDataCallback{
        void onDataLoaded(List<Entry> entries);
    }

    List<? extends Entry> getData(Integer pos);

    void addData(List<? extends Entry> entries,String label);

    void removeData(Integer pos);

    void updateData(Integer pos, List<? extends Entry> entries, String label);

    int count();

}
