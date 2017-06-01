package com.viseator.chartit.activity.chart;

import android.os.Bundle;

import com.viseator.chartit.BaseActivity;
import com.viseator.chartit.R;
import com.viseator.chartit.data.chart.ChartDataRepository;
import com.viseator.chartit.data.chart.local.LocalChartData;
import com.viseator.chartit.data.style.ChartSetStyle;
import com.viseator.chartit.data.style.ChartStyle;

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
        ChartStyle.getChartStyleEntity(getChartStyleDao());
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_line_chart;
    }

    @Override
    protected void baseInit() {
        mPos = getIntent().getIntExtra("position", -1);
        mPresenter = new LineChartPresenter(ChartDataRepository.
                getInstance(LocalChartData.getInstance(getChartDataDao())), mLineChartView, new
                ChartSetStyle(getChartSetStyleEntityDao()), mPos);
    }

    @Override
    protected void initView() {
        mPresenter.initView();
    }
}
