package com.viseator.chartit.activity.chart.barchart;

import android.os.Bundle;

import com.viseator.chartit.BaseActivity;
import com.viseator.chartit.R;
import com.viseator.chartit.activity.chart.ChartActivity;
import com.viseator.chartit.adapter.ChartViewPagerAdapter;

import butterknife.ButterKnife;

/**
 * Created by viseator on 10/18/17.
 * Wu Di
 * viseator@gmail.com
 */

public class BarChartActivity extends ChartActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setFullScreen();
        setContentView(R.layout.activity_bar_chart);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initChartActivity() {
        mChartType = ChartViewPagerAdapter.TYPE_BAR_CHART;
        mTabLayout = ButterKnife.findById(this, R.id.bar_chart_tablayout);
        mViewPager = ButterKnife.findById(this, R.id.bar_chart_viewpager);
    }

}
