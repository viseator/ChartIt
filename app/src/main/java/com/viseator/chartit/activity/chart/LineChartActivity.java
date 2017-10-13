package com.viseator.chartit.activity.chart;

import android.os.Bundle;

import com.github.mikephil.charting.data.Entry;
import com.viseator.chartit.BaseActivity;
import com.viseator.chartit.R;
import com.viseator.chartit.data.chart.ChartDataRepository;
import com.viseator.chartit.data.chart.local.LocalChartData;
import com.viseator.chartit.data.style.ChartSetStyle;
import com.viseator.chartit.data.style.ChartStyle;

import java.util.ArrayList;
import java.util.List;

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
        mPresenter = new LineChartPresenter(this, ChartDataRepository.
                getInstance(LocalChartData.getInstance(getChartDataDao())), mLineChartView, new
                ChartSetStyle(getChartSetStyleEntityDao()), getChartStyleDao(), mPos);
    }

    @Override
    protected void initView() {
        mPresenter.initView();
    }

    @Override
    protected void onPause() {
        super.onPause();
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < mLineChartView.getData().getDataSetByIndex(0).getEntryCount(); i++) {
            entries.add(mLineChartView.getData().getDataSetByIndex(0).getEntryForIndex(i));
        }
        mPresenter.updateData(entries);
    }
}
