package com.viseator.chartit.activity.chart;

import android.os.Bundle;

import com.viseator.chartit.BaseActivity;
import com.viseator.chartit.R;

public class LineChartActivity extends BaseActivity {

    private int mPos;
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

    }
}
