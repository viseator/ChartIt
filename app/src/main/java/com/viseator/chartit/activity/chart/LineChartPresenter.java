package com.viseator.chartit.activity.chart;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.viseator.chartit.data.IDataSource;

import java.util.List;

/**
 * Created by viseator on 5/30/17.
 * Wu Di
 * Email: viseator@gmail.com
 */

public class LineChartPresenter implements LineChartContract.Presenter {

    private IDataSource mChartDataRepo;

    private LineChartContract.View mView;
    private int mPos;

    public LineChartPresenter(IDataSource dataSource, LineChartContract.View view,int pos) {
        mChartDataRepo = dataSource;
        mView = view;
        mPos = pos;
    }

    public void initView() {
        List<Entry> entries = (List<Entry>) mChartDataRepo.getData(mPos);
        LineDataSet lineDataSet = new LineDataSet(entries, mChartDataRepo.getLabel(mPos));
        LineData lineData = new LineData(lineDataSet);
        mView.setData(lineData);
    }

}
