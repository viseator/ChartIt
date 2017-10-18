package com.viseator.chartit.activity.chart.linechart;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.viseator.chartit.BaseActivity;
import com.viseator.chartit.R;
import com.viseator.chartit.adapter.ChartViewPagerAdapter;

import butterknife.BindView;

public class LineChartActivity extends BaseActivity {

    private int mPos;
    @BindView(R.id.line_chart_tablayout)
    TabLayout mTabLayout;
    @BindView(R.id.line_chart_viewpager)
    ViewPager mViewPager;

    private ChartViewPagerAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setFullScreen();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_line_chart;
    }

    @Override
    protected void baseInit() {
        mPos = getIntent().getIntExtra("position", -1);
    }

    @Override
    protected void initView() {
        mAdapter = new ChartViewPagerAdapter(getSupportFragmentManager(), this, mPos,
                ChartViewPagerAdapter.TYPE_LINE_CHART);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int
                    positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 1) {
                    mAdapter.saveLineChartState();
                }
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        mAdapter.saveLineChartState();
    }

}
