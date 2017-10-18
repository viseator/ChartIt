package com.viseator.chartit.activity.chart.barchart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.viseator.chartit.ChartViewFragment;
import com.viseator.chartit.R;
import com.viseator.chartit.data.chart.ChartDataRepository;
import com.viseator.chartit.utils.DataCoverter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by viseator on 10/18/17.
 * Wu Di
 * viseator@gmail.com
 */

public class BarChartFragment extends ChartViewFragment {
    private static final String TAG = "@vir BarChartFragment";
    @BindView(R.id.bar_chart)
    BarChart mBarChart;
    private ChartDataRepository mChartDataRepository;
    private int mPos;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mChartDataRepository = ChartDataRepository.getInstance();
        mPos = getArguments().getInt("pos");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bar_chart, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void updateData() {
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < mBarChart.getData().getDataSetByIndex(0).getEntryCount(); i++) {
            entries.add(mBarChart.getData().getDataSetByIndex(0).getEntryForIndex(i));
        }
        mChartDataRepository.updateData(mPos, entries, mChartDataRepository.getLabel(mPos));
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        List<BarEntry> entries = DataCoverter.toBarEntries((List<Entry>) mChartDataRepository
                .getData(mPos));
        BarDataSet barDataSet = new BarDataSet(entries, mChartDataRepository.getLabel(mPos));
        BarData barData = new BarData(barDataSet);
        mBarChart.setData(barData);
    }
}
