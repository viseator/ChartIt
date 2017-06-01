package com.viseator.chartit.activity.chart;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.viseator.chartit.BaseView;
import com.viseator.chartit.data.style.ChartSetStyleEntity;
import com.viseator.chartit.utils.axis.XAxisSetter;
import com.viseator.chartit.utils.axis.YAxisSetter;

import java.util.List;

/**
 * Created by viseator on 5/30/17.
 * Wu Di
 * Email: viseator@gmail.com
 */

public class LineChartView extends LineChart implements LineChartContract.View{
    private static final String TAG = "@vir LineChartView";
    private LineChartContract.Presenter mPresenter;
    private XAxisSetter mXAxisSetter;
    private YAxisSetter mYAxisSetter;
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

    @Override
    public void init(LineData lineData) {
        getAxisRight().setEnabled(false);
        XAxis xAxis = getXAxis();
        YAxis yAxis  = getAxisLeft();
        mXAxisSetter = new XAxisSetter(xAxis);
        mYAxisSetter = new YAxisSetter(yAxis);
        // TODO: 6/1/17 set Axis properties
        super.setData(lineData);
        super.setDescription(null);
    }

    @Override
    public void showChartSetStylesList(List<ChartSetStyleEntity> list) {
        // TODO: 6/1/17 show chart set styles in a way
    }


}
