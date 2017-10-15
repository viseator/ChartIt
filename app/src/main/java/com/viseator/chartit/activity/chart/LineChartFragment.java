package com.viseator.chartit.activity.chart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.data.Entry;
import com.viseator.chartit.BaseFragment;
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

public class LineChartFragment extends BaseFragment {

    private static final String TAG = "@vir LineChartFragment";
    @BindView(R.id.line_chart)
    LineChartView mLineChartView;
    LineChartContract.Presenter mPresenter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_line_chart, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        updateData();
    }

    public void updateData(){
        Log.d(TAG, String.valueOf("onPause"));
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < mLineChartView.getData().getDataSetByIndex(0).getEntryCount(); i++) {
            entries.add(mLineChartView.getData().getDataSetByIndex(0).getEntryForIndex(i));
        }
        mPresenter.updateData(entries);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = new LineChartPresenter(getActivity(), ChartDataRepository.
                getInstance(LocalChartData.getInstance(getChartDataDao())), mLineChartView, new
                ChartSetStyle(getChartSetStyleEntityDao()), getChartStyleDao());
        mPresenter.initView();
        mPresenter.setViewData(getArguments().getInt("pos"));
    }
}
