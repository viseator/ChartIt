package com.viseator.chartit.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.viseator.chartit.BaseActivity;
import com.viseator.chartit.R;

public class LineChartActivity extends BaseActivity {

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
    protected void initView() {

    }

    @Override
    protected void baseInit() {

    }
}
