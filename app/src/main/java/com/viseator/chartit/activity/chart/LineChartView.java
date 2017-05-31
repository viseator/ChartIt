package com.viseator.chartit.activity.chart;

import android.content.Context;
import android.util.AttributeSet;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.viseator.chartit.BaseView;

/**
 * Created by viseator on 5/30/17.
 * Wu Di
 * Email: viseator@gmail.com
 */

public class LineChartView extends LineChart implements LineChartContract.View{
    private LineChartContract.Presenter mPresenter;
    public LineChartView(Context context) {
        super(context);
    }

    public LineChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LineChartView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void setPresenter(LineChartContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void setData(LineData lineData) {
        super.setData(lineData);
    }
}
