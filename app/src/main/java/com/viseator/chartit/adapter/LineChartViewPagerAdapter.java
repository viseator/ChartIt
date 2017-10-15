package com.viseator.chartit.adapter;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.viseator.chartit.R;
import com.viseator.chartit.activity.chart.LineChartFragment;
import com.viseator.chartit.fragment.DataAddModifyFragment;

/**
 * Created by viseator on 10/15/17.
 * Wu Di
 * viseator@gmail.com
 */

public class LineChartViewPagerAdapter extends FragmentStatePagerAdapter {
    private Context mContext;
    private int mPos;
    private LineChartFragment mLineChartFragment;

    public LineChartViewPagerAdapter(FragmentManager fm, Context context, int pos) {
        super(fm);
        mContext = context;
        mPos = pos;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            Bundle bundle = new Bundle();
            bundle.putInt("pos", mPos);
            mLineChartFragment = new LineChartFragment();
            mLineChartFragment.setArguments(bundle);
            return mLineChartFragment;
        } else {
            Bundle bundle = new Bundle();
            bundle.putInt("position", mPos);
            DataAddModifyFragment dataAddModifyFragment = new DataAddModifyFragment();
            dataAddModifyFragment.setArguments(bundle);
            return dataAddModifyFragment;
        }
    }

    public void saveLineChartState(){
        mLineChartFragment.updateData();
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
