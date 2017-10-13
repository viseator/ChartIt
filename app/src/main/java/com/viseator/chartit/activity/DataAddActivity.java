package com.viseator.chartit.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.github.mikephil.charting.data.Entry;
import com.viseator.chartit.App;
import com.viseator.chartit.BaseActivity;
import com.viseator.chartit.R;
import com.viseator.chartit.activity.chart.LineChartActivity;
import com.viseator.chartit.adapter.DataAddAdapter;
import com.viseator.chartit.data.chart.ChartDataEntityDao;
import com.viseator.chartit.data.chart.ChartDataRepository;
import com.viseator.chartit.data.chart.local.LocalChartData;
import com.viseator.chartit.data.style.DaoSession;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class DataAddActivity extends BaseActivity {

    @BindView(R.id.data_add_recyclerview)
    RecyclerView mRecyclerView;
    @BindView(R.id.generate_chart_button)
    Button mButton;
    @BindView(R.id.data_add_title)
    EditText mEditText;
    DaoSession daoSession;
    ChartDataEntityDao chartDataEntityDao;
    ChartDataRepository mChartDataRepository;
    LocalChartData mLocalChartData;

    private DataAddAdapter mDataAddAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_data_add;
    }

    @Override
    protected void baseInit() {
        daoSession = ((App) getApplication()).getDaoSession();
        chartDataEntityDao = daoSession.getChartDataEntityDao();
        mLocalChartData = LocalChartData.getInstance(chartDataEntityDao);
        mChartDataRepository = ChartDataRepository.getInstance(mLocalChartData);

    }

    @Override
    protected void initView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mDataAddAdapter = new DataAddAdapter(this);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mDataAddAdapter);

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
                DataAddAdapter.MainViewHolder holder = (DataAddAdapter.MainViewHolder) viewHolder;
                mDataAddAdapter.removeItem(holder.getPos());
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);
    }


    @OnClick(R.id.generate_chart_button)
    void onClick() {
        if (getCurrentFocus() != null) {
            getCurrentFocus().clearFocus();
        }
        List<Entry> entries = mDataAddAdapter.getEntries();
        if (entries.size() < 2) {
            Toast.makeText(this, getResources().getString(R.string.no_enough_point), Toast
                    .LENGTH_SHORT).show();
            return;
        }
        mChartDataRepository.addData(entries, mEditText.getText().toString());
        Intent intent = new Intent(getApplicationContext(), LineChartActivity.class);
        intent.putExtra("position", mChartDataRepository.count() - 1);
        startActivity(intent);
        finish();
    }
}
