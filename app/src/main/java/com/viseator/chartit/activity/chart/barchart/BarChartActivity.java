package com.viseator.chartit.activity.chart.barchart;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.viseator.chartit.BaseActivity;
import com.viseator.chartit.ChartViewFragment;
import com.viseator.chartit.R;
import com.viseator.chartit.adapter.ChartViewPagerAdapter;

import butterknife.BindView;

/**
 * Created by viseator on 10/18/17.
 * Wu Di
 * viseator@gmail.com
 */

public class BarChartActivity extends BaseActivity{
    private static final String TAG = "@vir BarChartActivity";
    private int mPos;
    @BindView(R.id.bar_chart_tablayout)
    TabLayout mTablayout;
    @BindView(R.id.bar_chart_viewpager)
    ViewPager mViewPager;

    private ChartViewPagerAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setFullScreen();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_bar_chart;
    }

    @Override
    protected void baseInit() {
        mPos = getIntent().getIntExtra("position", -1);
    }

    @Override
    protected void initView() {

    }
}
