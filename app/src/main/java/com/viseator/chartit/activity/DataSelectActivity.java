package com.viseator.chartit.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.utils.EntryXComparator;
import com.viseator.chartit.App;
import com.viseator.chartit.BaseActivity;
import com.viseator.chartit.R;
import com.viseator.chartit.adapter.SelectAdapter;
import com.viseator.chartit.data.chart.ChartDataEntityDao;
import com.viseator.chartit.data.chart.ChartDataRepository;
import com.viseator.chartit.data.chart.local.LocalChartData;
import com.viseator.chartit.data.style.DaoSession;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;

/**
 * Created by viseator on 5/29/17.
 * Wu Di
 * Email: viseator@gmail.com
 */

public class DataSelectActivity extends BaseActivity {
    @BindView(R.id.data_recyclerView)
    RecyclerView mRecyclerView;
    DaoSession daoSession;
    ChartDataEntityDao chartDataEntityDao;
    ChartDataRepository mChartDataRepository;
    LocalChartData mLocalChartData;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mChartDataRepository.removeAllData();
        for (int i = 0; i < 10; i++) {
            test();
        }
    }

    private void test() {
        List<Entry> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Entry entry = new Entry(i, ((float) Math.random()));
            entry.setData(String.valueOf(i) + "t");
            list.add(entry);
        }
        Collections.sort(list, new EntryXComparator());
        mChartDataRepository.addData(list, "label");
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_data_selecte;
    }

    @Override
    protected void initView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(new SelectAdapter(this));
    }

    @Override
    protected void baseInit() {
        daoSession = ((App) getApplication()).getDaoSession();
        chartDataEntityDao = daoSession.getChartDataEntityDao();
        mLocalChartData = LocalChartData.getInstance(chartDataEntityDao);
        mChartDataRepository = ChartDataRepository.getInstance(mLocalChartData);
    }
}
