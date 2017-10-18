package com.viseator.chartit.activity.chart.linechart;

import com.viseator.chartit.R;
import com.viseator.chartit.activity.chart.ChartActivity;
import com.viseator.chartit.adapter.ChartViewPagerAdapter;

import butterknife.ButterKnife;

public class LineChartActivity extends ChartActivity {

    @Override
    protected void initChartActivity() {
        mChartType = ChartViewPagerAdapter.TYPE_LINE_CHART;
        mTabLayout = ButterKnife.findById(this, R.id.line_chart_tablayout);
        mViewPager = ButterKnife.findById(this, R.id.line_chart_viewpager);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_line_chart;
    }

}
