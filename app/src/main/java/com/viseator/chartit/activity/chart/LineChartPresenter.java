package com.viseator.chartit.activity.chart;

import android.graphics.Color;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.viseator.chartit.data.chart.IDataSource;
import com.viseator.chartit.data.style.ChartSetStyle;
import com.viseator.chartit.data.style.ChartSetStyleEntity;

import java.util.List;

/**
 * Created by viseator on 5/30/17.
 * Wu Di
 * Email: viseator@gmail.com
 */

public class LineChartPresenter implements LineChartContract.Presenter {

    private IDataSource mChartDataRepo;
    private ChartSetStyle mChartSetStyle;

    private LineChartContract.View mView;
    private int mPos;

    public void showAllChartSetStyles() {
        List<ChartSetStyleEntity> list = mChartSetStyle.getAllChartSetStyles();
        mView.showChartSetStylesList(list);
    }

    public LineChartPresenter(IDataSource dataSource, LineChartContract.View view,int pos) {
        mChartDataRepo = dataSource;
        mView = view;
        mPos = pos;
    }

    public void initView() {
        List<Entry> entries = (List<Entry>) mChartDataRepo.getData(mPos);
        LineDataSet lineDataSet = new LineDataSet(entries, mChartDataRepo.getLabel(mPos));

        lineDataSet.setDrawFilled(true);
        lineDataSet.setFillColor(Color.parseColor("#328912"));
        lineDataSet.setFillAlpha(255);
        LineData lineData = new LineData(lineDataSet);
        mView.init(lineData); // TODO: 6/1/17 separate init and set data
    }

}
