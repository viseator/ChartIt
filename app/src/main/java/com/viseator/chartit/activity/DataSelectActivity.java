package com.viseator.chartit.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;

import com.viseator.chartit.App;
import com.viseator.chartit.BaseActivity;
import com.viseator.chartit.R;
import com.viseator.chartit.activity.chart.barchart.BarChartActivity;
import com.viseator.chartit.activity.chart.linechart.LineChartActivity;
import com.viseator.chartit.adapter.SelectAdapter;
import com.viseator.chartit.data.chart.ChartDataEntityDao;
import com.viseator.chartit.data.chart.ChartDataRepository;
import com.viseator.chartit.data.chart.DaoSession;
import com.viseator.chartit.data.chart.local.LocalChartData;
import com.viseator.chartit.data.style.ChartStyle;

import butterknife.BindView;

/**
 * Created by viseator on 5/29/17.
 * Wu Di
 * Email: viseator@gmail.com
 */

public class DataSelectActivity extends BaseActivity {
    private static final String TAG = "@vir DataSelectActivity";
    @BindView(R.id.data_recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.add_new_data_button)
    FloatingActionButton mButton;
    @BindView(R.id.select_drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.type_select_radio_group)
    RadioGroup mRadioGroup;
    private DaoSession daoSession;
    private ChartDataEntityDao chartDataEntityDao;
    private ChartDataRepository mChartDataRepository;
    private LocalChartData mLocalChartData;
    private SelectAdapter mSelectAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_data_select);
        super.onCreate(savedInstanceState);
        ChartStyle.getChartStyleEntity(getChartStyleDao());
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
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d(TAG, String.valueOf(checkedId));
                switch (checkedId) {
                    case R.id.line_chart_radio_button:
                        mSelectAdapter.setTargetActivity(LineChartActivity.class);
                        break;
                    case R.id.bar_chart_radio_button:
                        mSelectAdapter.setTargetActivity(BarChartActivity.class);
                        break;
                }
            }
        });
        mRadioGroup.check(R.id.line_chart_radio_button);
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
