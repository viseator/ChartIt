package com.viseator.chartit.adapter;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.viseator.chartit.ChartViewFragment;
import com.viseator.chartit.R;
import com.viseator.chartit.activity.chart.barchart.BarChartFragment;
import com.viseator.chartit.activity.chart.linechart.LineChartFragment;
import com.viseator.chartit.fragment.DataAddModifyFragment;

/**
 * Created by viseator on 10/15/17.
 * Wu Di
 * viseator@gmail.com
 */

public class ChartViewPagerAdapter extends FragmentStatePagerAdapter {
    private Context mContext;
    private int mPos;
    private ChartViewFragment mChartViewFragment;
    public static final int TYPE_LINE_CHART = 0x01;
    public static final int TYPE_BAR_CHART = 0x02;
    private int mType;

    public ChartViewPagerAdapter(FragmentManager fm, Context context, int pos, int type) {
        super(fm);
        mContext = context;
        mPos = pos;
        mType = type;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            Bundle bundle = new Bundle();
            bundle.putInt("pos", mPos);
            switch (mType) {
                case TYPE_LINE_CHART:
                    mChartViewFragment = new LineChartFragment();
                    break;
                case TYPE_BAR_CHART:
                    mChartViewFragment = new BarChartFragment();
                    break;
            }
            mChartViewFragment.setArguments(bundle);
            return mChartViewFragment;
        } else {
            Bundle bundle = new Bundle();
            bundle.putInt("position", mPos);
            DataAddModifyFragment dataAddModifyFragment = new DataAddModifyFragment();
            dataAddModifyFragment.setArguments(bundle);
            return dataAddModifyFragment;
        }
    }

    public void saveLineChartState() {
        mChartViewFragment.updateData();
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getResources().getString(R.string.chart);
        } else {
            return mContext.getResources().getString(R.string.data);
        }
    }
}
