package com.viseator.chartit.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by viseator on 10/15/17.
 * Wu Di
 * viseator@gmail.com
 */

public class ChartViewPager extends ViewPager{


    public ChartViewPager(Context context) {
        super(context);
    }

    public ChartViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }
}
