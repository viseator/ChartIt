package com.viseator.chartit.activity.chart.barchart;

import android.content.Context;
import android.util.AttributeSet;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.viseator.chartit.listener.BarChartTouchListener;
import com.viseator.chartit.utils.axis.XAxisSetter;
import com.viseator.chartit.utils.axis.YAxisSetter;

/**
 * Created by wudi.viseator on 2018/5/20.
 * Wu Di
 * wudi.viseator@bytedance.com
 */
public class BarChartView extends BarChart implements UiCallback{

    private XAxisSetter mXAxisSetter;
    private YAxisSetter mYAxisSetter;

    public BarChartView(Context context) {
        super(context);
        initView();
    }

    public BarChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public BarChartView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
    }


    private void initView() {
        getAxisRight().setEnabled(false);
        XAxis xAxis = getXAxis();
        YAxis yAxis = getAxisLeft();
        mXAxisSetter = new XAxisSetter(xAxis);
        mYAxisSetter = new YAxisSetter(yAxis);
        super.setDescription(null);
        super.setDragEnabled(true);
        super.setDoubleTapToZoomEnabled(false);
        super.setHighlightPerTapEnabled(false);
        super.setHighlightPerDragEnabled(false);
    }

    @Override public void setTouchListener() {
        setOnTouchListener(new BarChartTouchListener(this, getMatrix(), 3f));
    }
}
