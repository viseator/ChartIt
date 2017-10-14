package com.viseator.chartit.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Button;

import com.viseator.chartit.App;
import com.viseator.chartit.BaseActivity;
import com.viseator.chartit.R;
import com.viseator.chartit.adapter.DataAddAdapter;
import com.viseator.chartit.adapter.SelectAdapter;
import com.viseator.chartit.data.chart.ChartDataEntityDao;
import com.viseator.chartit.data.chart.ChartDataRepository;
import com.viseator.chartit.data.chart.local.LocalChartData;
import com.viseator.chartit.data.style.ChartStyle;
import com.viseator.chartit.data.style.DaoSession;

import butterknife.BindView;

/**
 * Created by viseator on 5/29/17.
 * Wu Di
 * Email: viseator@gmail.com
 */

public class DataSelectActivity extends BaseActivity {
    @BindView(R.id.data_recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.add_new_data_button)
    FloatingActionButton mButton;

    private DaoSession daoSession;
    private ChartDataEntityDao chartDataEntityDao;
    private ChartDataRepository mChartDataRepository;
    private LocalChartData mLocalChartData;
    private SelectAdapter mSelectAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ChartStyle.getChartStyleEntity(getChartStyleDao());
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_data_select;
    }

    @Override
    protected void initView() {
        mSelectAdapter = new SelectAdapter(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mSelectAdapter);
        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                                  RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                if (getCurrentFocus() != null) {
                    getCurrentFocus().clearFocus();
                }
                SelectAdapter.ViewHolder holder = (SelectAdapter.ViewHolder) viewHolder;
                mSelectAdapter.removeItem(holder.getPos());
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataSelectActivity.this, DataAddActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSelectAdapter.notifyDataSetChanged(); // FIXME: 10/13/17 bug when refresh data
    }

    @Override
    protected void baseInit() {
        daoSession = ((App) getApplication()).getDaoSession();
        chartDataEntityDao = daoSession.getChartDataEntityDao();
        mLocalChartData = LocalChartData.getInstance(chartDataEntityDao);
        mChartDataRepository = ChartDataRepository.getInstance(mLocalChartData);
    }
}
