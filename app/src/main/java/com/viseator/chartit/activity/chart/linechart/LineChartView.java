package com.viseator.chartit.activity.chart.linechart;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;

import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.viseator.chartit.BaseView;
import com.viseator.chartit.R;
import com.viseator.chartit.data.style.ChartSetStyleEntity;
import com.viseator.chartit.data.style.ChartStyle;
import com.viseator.chartit.data.style.ChartStyleEntity;
import com.viseator.chartit.listener.LineChartTouchListener;
import com.viseator.chartit.utils.NullChecker;
import com.viseator.chartit.utils.axis.XAxisSetter;
import com.viseator.chartit.utils.axis.YAxisSetter;

import java.util.List;

/**
 * Created by viseator on 5/30/17.
 * Wu Di
 * Email: viseator@gmail.com
 */

public class LineChartView extends LineChart implements LineChartContract.View {
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
    public void initChart() {
        getAxisRight().setEnabled(false);
        XAxis xAxis = getXAxis();
        YAxis yAxis = getAxisLeft();
        mXAxisSetter = new XAxisSetter(xAxis);
        mYAxisSetter = new YAxisSetter(yAxis);
        // TODO: 6/1/17 set Axis properties
        super.setDescription(null);
        super.setDragEnabled(true);
        super.setDoubleTapToZoomEnabled(false);
        super.setHighlightPerTapEnabled(false);
        super.setHighlightPerDragEnabled(false);
    }

    @Override
    public void showChartSetStylesList(List<ChartSetStyleEntity> list) {
        // TODO: 6/1/17 show chart set styles in a way
    }

    @Override
    public void setOnTouchListener(){
        super.setOnTouchListener(new LineChartTouchListener(this, mViewPortHandler.getMatrixTouch
                (), 3f));
    }

    @Override
    public void setLabelCount(int count) {
        mXAxisSetter.setLabelCount(count - 1);
    }

    @Override
    public void setProperties(ChartStyleEntity chartStyle) {
        if (NullChecker.isSetted(chartStyle.getBackgroundColor())) {
            super.setBackgroundColor(Color.parseColor(chartStyle.getBackgroundColor()));
        }
        if (NullChecker.isSetted(chartStyle.getDescription())) {
            Description des = new Description();
            des.setText(chartStyle.getDescription());
            super.setDescription(des);
        }
        if (NullChecker.isSetted(chartStyle.getDrawGrid())) {
            super.setDrawGridBackground(chartStyle.getDrawGrid());
        }
        if (NullChecker.isSetted(chartStyle.getGridColor())) {
            super.setGridBackgroundColor(Color.parseColor(chartStyle.getGridColor()));
        }
        if (NullChecker.isSetted(chartStyle.getBorderColor())) {
            super.setBorderColor(Color.parseColor(chartStyle.getBorderColor()));
        }
        if (NullChecker.isSetted(chartStyle.getBorderWidth())) {
            super.setBorderWidth(chartStyle.getBorderWidth());
        }
        if (NullChecker.isSetted(chartStyle.getMaxVisibleValueCount())) {
            super.setMaxVisibleValueCount(chartStyle.getMaxVisibleValueCount());
        }
        if (NullChecker.isSetted(chartStyle.getEnableXAxis())) {
            mXAxisSetter.setEnabled(chartStyle.getEnableXAxis());
        }
        if (NullChecker.isSetted(chartStyle.getEnableYAxis())) {
            mYAxisSetter.setEnabled(chartStyle.getEnableYAxis());
        }
        if (NullChecker.isSetted(chartStyle.getDrawXAxisLabel())) {
            mXAxisSetter.setDrawLabels(chartStyle.getDrawXAxisLabel());
        }
        if (NullChecker.isSetted(chartStyle.getDrawYAxisLabel())) {
            mYAxisSetter.setDrawLabels(chartStyle.getDrawYAxisLabel());
        }
        if (NullChecker.isSetted(chartStyle.getDrawXAxisLine())) {
            mXAxisSetter.setDrawAxisLine(chartStyle.getDrawXAxisLine());
        }
        if (NullChecker.isSetted(chartStyle.getDrawYAxisLine())) {
            mYAxisSetter.setDrawAxisLine(chartStyle.getDrawYAxisLine());
        }
        if (NullChecker.isSetted(chartStyle.getDrawXAxisGridLines())) {
            mXAxisSetter.setDrawGridLines(chartStyle.getDrawXAxisGridLines());
        }
        if (NullChecker.isSetted(chartStyle.getDrawYAxisGridLines())) {
            mYAxisSetter.setDrawGridLines(chartStyle.getDrawYAxisGridLines());
        }
        if (NullChecker.isSetted(chartStyle.getXAxisGridLineWidth())) {
            mXAxisSetter.setGridLineWidth(chartStyle.getXAxisGridLineWidth());
        }
        if (NullChecker.isSetted(chartStyle.getYAxisGridLineWidth())) {
            mYAxisSetter.setGridLineWidth(chartStyle.getYAxisGridLineWidth());
        }
        if (NullChecker.isSetted(chartStyle.getSetXAxisGridDashLine())) {
            mXAxisSetter.enableGridDashedLine(chartStyle.getSetXAxisGridDashLine());
        }
        if (NullChecker.isSetted(chartStyle.getSetYAxisGridDashLine())) {
            mYAxisSetter.enableGridDashedLine(chartStyle.getSetYAxisGridDashLine());
        }
        if (NullChecker.isSetted(chartStyle.getTextSize())) {
            mXAxisSetter.setTextSize(chartStyle.getTextSize());
            mYAxisSetter.setTextSize(chartStyle.getTextSize());
        }
        if (NullChecker.isSetted(chartStyle.getXAxisPosition())) {
            mXAxisSetter.setPosition(chartStyle.getXAxisPosition());
        }
        if (NullChecker.isSetted(chartStyle.getXAxisTextColor())) {
            mXAxisSetter.setTextColor((chartStyle.getXAxisTextColor()));
        }
        if (NullChecker.isSetted(chartStyle.getYAxisTextColor())) {
            mYAxisSetter.setTextColor((chartStyle.getYAxisTextColor()));
        }
        if (NullChecker.isSetted(chartStyle.getDrawZeroLine())) {
            mYAxisSetter.setDrawZeroLine(chartStyle.getDrawZeroLine());
        }
        if (NullChecker.isSetted(chartStyle.getZeroLineColor())) {
            mYAxisSetter.setZeroLineColor(Color.parseColor(chartStyle.getZeroLineColor()));
        }
        if (NullChecker.isSetted(chartStyle.getDrawLegend())) {
            if (chartStyle.getDrawLegend()) {
                super.getLegend().setEnabled(true);
            } else {
                super.getLegend().setEnabled(false);
            }
        }

    }

    @Override
    public void setXFormatter(IAxisValueFormatter formatter) {
        mXAxisSetter.setFormatter(formatter);
        mXAxisSetter.setLabelCount(getData().getEntryCount() - 1);
    }

    @Override
    public void cancelFormatter() {
        mXAxisSetter.cancelFormatter();
    }


}
