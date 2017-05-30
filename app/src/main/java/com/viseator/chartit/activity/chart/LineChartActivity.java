package com.viseator.chartit.activity.chart;

import android.os.Bundle;

import com.viseator.chartit.BaseActivity;
import com.viseator.chartit.R;
import com.viseator.chartit.data.ChartDataRepository;
import com.viseator.chartit.data.local.LocalChartData;

import butterknife.BindView;

public class LineChartActivity extends BaseActivity {

    @BindView(R.id.line_chart)
    LineChartView mLineChartView;
    LineChartContract.Presenter mPresenter;
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
        mPresenter = new LineChartPresenter(ChartDataRepository.
                getInstance(LocalChartData.getInstance(getDao())), mLineChartView,mPos);
    }

    @Override
    protected void initView() {
        mPresenter.initView();
    }
}
