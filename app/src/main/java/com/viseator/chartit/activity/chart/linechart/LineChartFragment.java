package com.viseator.chartit.activity.chart.linechart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.data.Entry;
import com.viseator.chartit.BaseFragment;
import com.viseator.chartit.ChartViewFragment;
import com.viseator.chartit.R;
import com.viseator.chartit.data.chart.ChartDataRepository;
import com.viseator.chartit.data.chart.local.LocalChartData;
import com.viseator.chartit.data.style.ChartSetStyle;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by viseator on 10/14/17.
 * Wu Di
 * viseator@gmail.com
 */

public class LineChartFragment extends ChartViewFragment {

    private static final String TAG = "@vir LineChartFragment";
    @BindView(R.id.line_chart)
    LineChartView mLineChartView;
    LineChartContract.Presenter mPresenter;

    private int mPos;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle
            savedInstanceState) {
        mPos = getArguments().getInt("pos");
        View view = inflater.inflate(R.layout.fragment_line_chart, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void updateData() {
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < mLineChartView.getData().getDataSetByIndex(0).getEntryCount(); i++) {
            entries.add(mLineChartView.getData().getDataSetByIndex(0).getEntryForIndex(i));
        }
        mPresenter.updateData(mPos, entries);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = new LineChartPresenter(getActivity(), ChartDataRepository.
                getInstance(), mLineChartView, new
                ChartSetStyle(getChartSetStyleEntityDao()), getChartStyleDao());
        mPresenter.initView();
        mPresenter.setViewData(mPos);
    }
}
