package com.viseator.chartit.activity.chart.linechart;

import android.os.Bundle;

import com.viseator.chartit.R;
import com.viseator.chartit.activity.chart.ChartActivity;
import com.viseator.chartit.adapter.ChartViewPagerAdapter;

import butterknife.ButterKnife;

public class LineChartActivity extends ChartActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setFullScreen();
        setContentView(R.layout.activity_line_chart);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initChartActivity() {
        mChartType = ChartViewPagerAdapter.TYPE_LINE_CHART;
        mTabLayout = ButterKnife.findById(this, R.id.line_chart_tablayout);
        mViewPager = ButterKnife.findById(this, R.id.line_chart_viewpager);
    }

}
