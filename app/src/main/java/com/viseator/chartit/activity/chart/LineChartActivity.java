package com.viseator.chartit.activity.chart;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.viseator.chartit.BaseActivity;
import com.viseator.chartit.R;
import com.viseator.chartit.data.style.ChartStyle;

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
        Bundle bundle = new Bundle();
        bundle.putInt("pos", mPos);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        LineChartFragment lineChartFragment = new LineChartFragment();
        lineChartFragment.setArguments(bundle);
        fragmentTransaction.add(R.id.line_chart_fragment_container, lineChartFragment);
        fragmentTransaction.commit();
    }

}
