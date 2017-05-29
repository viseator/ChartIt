package com.viseator.chartit.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;

import com.github.mikephil.charting.data.Entry;
import com.viseator.chartit.App;
import com.viseator.chartit.BaseActivity;
import com.viseator.chartit.R;
import com.viseator.chartit.adapter.SelectAdapter;
import com.viseator.chartit.data.ChartDataEntityDao;
import com.viseator.chartit.data.ChartDataRepository;
import com.viseator.chartit.data.DaoSession;
import com.viseator.chartit.data.local.LocalChartData;

import java.util.ArrayList;
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
        test();
    }
    private void test() {
        List<Entry> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Entry entry = new Entry(((float) Math.random()), ((float) Math.random()));
            list.add(entry);
        }
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
