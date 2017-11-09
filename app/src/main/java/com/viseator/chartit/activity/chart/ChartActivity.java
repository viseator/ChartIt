package com.viseator.chartit.activity.chart;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.viseator.chartit.BaseActivity;
import com.viseator.chartit.adapter.ChartViewPagerAdapter;

public abstract class ChartActivity extends BaseActivity {

    protected int mPos;
    protected TabLayout mTabLayout;
    protected ViewPager mViewPager;
    protected int mChartType;

    protected ChartViewPagerAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void baseInit() {
        initChartActivity();
        mPos = getIntent().getIntExtra("position", -1);
    }

    protected abstract void initChartActivity();

    @Override
    protected void initView() {
        mAdapter = new ChartViewPagerAdapter(getSupportFragmentManager(), this, mPos, mChartType);
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
